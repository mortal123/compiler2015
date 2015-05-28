package compiler2015.intermediate;
/*
import java.util.*;

import compiler2015.ast.*;
import compiler2015.env.*;
import compiler2015.ir.*;

class ExprInfo {
	public Type type;
	public Address address;
	public Integer value;
	
	ExprInfo(Type a, Address b, Integer c) {
		type = a;
		address = b;
		value = c;
	}
};

public class Intermediate_without_offset {
	
	IntegerConst ZERO = new IntegerConst(0);
	
	private EnvironmentIR env;
	private LinkedList<Label> breakLabel, continueLabel;
	
	public Intermediate_without_offset() {
		env = new EnvironmentIR();
		breakLabel = new LinkedList<Label>();
		continueLabel = new LinkedList<Label>();
	}
	
	boolean isArray(Type type) {
		return type instanceof ArrayType || type instanceof StructType || type instanceof UnionType;
	}
	
	void assignGenerate(ExprInfo left, ExprInfo right, Function func) {
		Temp dest = new Temp(), src = new Temp();
		Temp temp = new Temp();
		func.body.add(new Assign(dest, left.address));
		func.body.add(new Assign(src, right.address));
		for (int i = 0; i < right.type.getSize(); i += 4) {
			func.body.add(new MemoryRead(temp, right.address, 4));
			func.body.add(new MemoryWrite(left.address, temp, 4));
			if (i + 4 < right.type.getSize()) {
				func.body.add(new ArithmeticExpr(right.address, ArithmeticOp.ADD, new IntegerConst(4)));
				func.body.add(new ArithmeticExpr(left.address, ArithmeticOp.ADD, new IntegerConst(4)));
			}
		}
	}
	
	public IR generateIR(AST ast) {
		List<Function> frags = new LinkedList<Function>();
		Function start = new Function("__start", 1);
		Type mainReturnType = null;
		for (Decl decl : ast.decls) {
			if (!(decl instanceof FunctionDecl)) {
				Variable var = generateVar(decl, start);
				if (var != null) {
					start.vars.add(generateVar(decl, start));
				}
			} else {
				FunctionDecl temp = (FunctionDecl) decl;
				if (temp.name == Symbol.get("main")) {
					mainReturnType = temp.returnType;
				}
			}
		}
		
		Temp temp = new Temp();
		if (isArray(mainReturnType)) {
			start.body.add(new Call(new MemoryParam(temp, mainReturnType.getSize()), "main", 0));
		} else {
			start.body.add(new Call(new BasicParam(temp), new String("main"), 0));
		}
		
		frags.add(start);
		
		for (Decl decl : ast.decls) {
			if (decl instanceof FunctionDecl) {
				frags.add(generateFunc((FunctionDecl)decl));
			}
		}
		
		return new IR(frags);
	}
	
	public Function generateFunc(FunctionDecl funcDecl) {
		env.beginScope();
		Function func = new Function(funcDecl.name.toString(), funcDecl.returnType.getSize());
		for (VarDecl var : funcDecl.params) {
			Variable ret = generateVar(var, func);
			if (ret != null) {
				func.args.add(ret);
			}
		}
		
		generateCompoundStmt(funcDecl.body, func);
		env.endScope();
		return func;
	}
	
	public Variable generateVar(Decl decl, Function func) {
		if (decl instanceof StructDecl) {
			StructDecl tmp = (StructDecl) decl;
			env.putType(tmp.tag, decl);
			env.beginScope();
			tmp.sizeOf = 0;
			for (VarDecl var : tmp.fields) {
				generateVar((Decl) var, func);
				tmp.sizeOf += var.type.getSize();
			}
			tmp.loadSize();
			env.endScope();
			return null;
		} else if (decl instanceof UnionDecl) {
			UnionDecl tmp = (UnionDecl) decl;
			env.putType(tmp.tag, decl);
			env.beginScope();
			tmp.sizeOf = 0;
			for (VarDecl var : tmp.fields) {
				generateVar((Decl) var, func);
				tmp.sizeOf = Math.max(tmp.sizeOf, var.type.getSize());
			}
			tmp.loadSize();
			env.endScope();
			return null;
		} else if (decl instanceof VarDecl) {
			VarDecl tmp = (VarDecl) decl;
			Type type = tmp.type;
			Name name = new Name(tmp.name.toString());
			env.putAddr(tmp.name, name);
			env.putIden(tmp.name, decl);
			if (tmp.init != null) {
				generateInitializer(name, type, tmp.init, func, 0);
			}
			if (type instanceof StructType || type instanceof ArrayType || type instanceof UnionType) { 
				return new ArrayVariable(tmp.name.toString(), type.getSize()); 
			} else {
				return new BasicVariable(tmp.name.toString(), type.getSize());
			}
		} else {
			System.err.println("fuck");
			return null;
		}
	}
	
	public void generateInitializer(Name name, Type type, Initializer init, Function func, int pos) {
		if (init instanceof InitValue) {
			ExprInfo info = generateExpr(((InitValue)init).expr, func, true);
			if (info.type instanceof StringType) {
				if (type instanceof PointerType) {
					func.body.add(new ArrayWrite(name, new IntegerConst(pos), info.address, 4));
				} else if (type instanceof ArrayType) {
					String str = ((StringAddressConst)(info.address)).value;
					for (int i = 0; i < str.length(); i++) {
						func.body.add(new ArrayWrite(name, new IntegerConst(pos + i), new IntegerConst(str.charAt(i)), 1));
					}
				} else {
					System.err.println("fuck");
				}
			} else if (isArray(info.type)) {
				Temp temp = new Temp(), addr = new Temp();
				func.body.add(new Assign(addr, info.address));
				for (int i = 0; i < info.type.getSize(); i += 4) {
					func.body.add(new MemoryRead(temp, addr, 4));
					func.body.add(new ArrayWrite(name, new IntegerConst(pos + i), temp, 4));
					if (i + 4 < info.type.getSize()) {
						func.body.add(new ArithmeticExpr(temp, ArithmeticOp.ADD, new IntegerConst(4)));
					}
				}
			} else {
				func.body.add(new ArrayWrite(name, new IntegerConst(pos), info.address, info.type.getSize()));
			}
		} else {
			// init must be InitList type
			InitList desc = (InitList)init;
			if (desc.inits.size() == 1 && desc.inits.get(0) instanceof InitValue && 
					((InitValue)(desc.inits.get(0))).expr instanceof StringConst) {
				init = desc.inits.get(0);
			}
			
			Type descType = type;
			if (type instanceof PointerType) {
				descType = ((PointerType)type).baseType;
			} else if (type instanceof ArrayType) {
				descType = ((ArrayType)type).baseType;
			}
			
			for (Initializer i : ((InitList)init).inits) {
				generateInitializer(name, descType, i, func, pos);
				pos += descType.getSize();
			}
		}
	}
	
	public void generateCompoundStmt(CompoundStmt cstmt, Function func) {
		env.beginScope();
		for (Decl decl : cstmt.decls) {
			generateVar(decl, func);
			// no functionDecl
		}
		for (Stmt stmt : cstmt.stats) {
			generateStmt(stmt, func);
		}
		env.endScope();
	}
	
	public IfTrueGoto ifFalse(Address addr, Label label) {
		return new IfTrueGoto(addr, RelationalOp.EQ, ZERO, label);
	}
	
	public IfFalseGoto ifTrue(Address addr, Label label) {
		return new IfFalseGoto(addr, RelationalOp.EQ, ZERO, label);
	}
	
	public void generateStmt(Stmt stmt, Function func) {
		if (stmt instanceof BreakStmt) {
			func.body.add(breakLabel.getLast());
		} else if (stmt instanceof ContinueStmt) {
			func.body.add(continueLabel.getLast());
		} else if (stmt instanceof IfStmt) {
			IfStmt tmp = (IfStmt)stmt;
			ExprInfo info = generateExpr(tmp.condition, func, false);
			
			if (tmp.alternative != null) {
				Label label1 = new Label(), label2 = new Label();
				func.body.add(ifFalse(info.address, label1));
				generateStmt(tmp.consequent, func);
				func.body.add(new Goto(label2));
				func.body.add(label1);
				generateStmt(tmp.alternative, func);
				func.body.add(label2);
			} else {
				Label label = new Label();
				func.body.add(ifFalse(info.address, label));
				generateStmt(tmp.consequent, func);
				func.body.add(label);
			}
		} else if (stmt instanceof ForLoop) {
			ForLoop tmp = (ForLoop)stmt;
			Label begin = new Label();
			continueLabel.add(begin);
			
			func.body.add(begin);
			if (tmp.init != null) {
				generateExpr(tmp.init, func, false);
			}
			if (tmp.condition != null) {
				ExprInfo info = generateExpr(tmp.condition, func, false);
				func.body.add(ifFalse(info.address, breakLabel.getLast()));
			}
			generateStmt(tmp.body, func);
			if (tmp.step != null) { 
				generateExpr(tmp.step, func, false);
			}
			func.body.add(new Goto(begin));
			breakLabel.add(new Label());
			func.body.add(breakLabel.getLast());
			breakLabel.removeLast();
			continueLabel.removeLast();
		} else if (stmt instanceof WhileLoop) {
			WhileLoop tmp = (WhileLoop)stmt;
			breakLabel.add(new Label());
			Label begin = new Label();
			continueLabel.add(begin);
			
			func.body.add(begin);
			if (tmp.condition != null) {
				ExprInfo info = generateExpr(tmp.condition, func, false);
				func.body.add(ifFalse(info.address, breakLabel.getLast()));
			}
			generateStmt(tmp.body, func);
			func.body.add(new Goto(begin));
			func.body.add(breakLabel.getLast());
			
			breakLabel.removeLast();
			continueLabel.removeLast();
		} else if (stmt instanceof ReturnStmt) {
			ReturnStmt tmp = (ReturnStmt)stmt;
			ExprInfo info = generateExpr(tmp.expr, func, false);
			if (isArray(info.type)) {
				func.body.add(new Return(new MemoryParam(info.address, info.type.getSize())));
			} else {
				func.body.add(new Return(new BasicParam(info.address)));
			}
		} else if (stmt instanceof CompoundStmt) {
			generateCompoundStmt((CompoundStmt) stmt, func);
		} else if (stmt instanceof Expr) {
			generateExpr((Expr)stmt, func, false);
		}
	}
	
	public ExprInfo generateExpr(Expr expr, Function func, boolean isLeft) {
		if (expr instanceof EmptyExpr) {
			return new ExprInfo(new IntType(), new IntegerConst(1), 1);
		} else if (expr instanceof BinaryExpr) {
			return generateBinaryExpr((BinaryExpr)expr, func);
		} else if (expr instanceof UnaryExpr) {
			return generateUnaryExpr((UnaryExpr)expr, func, isLeft);
		} else if (expr instanceof SizeofExpr) {
			return generateSizeofExpr((SizeofExpr)expr, func);
		} else if (expr instanceof CastExpr) {
			return generateCastExpr((CastExpr)expr, func, isLeft);
		} else if (expr instanceof PointerAccess) {
			return generatePointerAccess((PointerAccess)expr, func, isLeft);
		} else if (expr instanceof RecordAccess) {
			return generateRecordAccess((RecordAccess)expr, func, isLeft);
		} else if (expr instanceof SelfIncrement) {
			return generateSelfIncrement((SelfIncrement)expr, func);
		} else if (expr instanceof SelfDecrement) {
			return generateSelfDecrement((SelfDecrement)expr, func);
		} else if (expr instanceof ArrayAccess) {
			return generateArrayAccess((ArrayAccess)expr, func, isLeft);
		} else if (expr instanceof FunctionCall) {
			return generateFunctionCall((FunctionCall)expr, func);
		} else if (expr instanceof Identifier) {
			return generateIdentifier((Identifier)expr, func, isLeft);
		} else if (expr instanceof IntConst) {
			return new ExprInfo(new IntType(), new IntegerConst(((IntConst)expr).value), ((IntConst)expr).value);
		} else if (expr instanceof CharConst) {
			return new ExprInfo(new CharType(), new IntegerConst(((CharConst)expr).value.charAt(0)), Integer.valueOf(((CharConst)expr).value.charAt(0)));
		} else if (expr instanceof StringConst) {
			String str = ((StringConst)expr).value;
			return new ExprInfo(new StringType(str.length()), new StringAddressConst(str), 0);
		} else {
			System.err.println("Unknown Expression!");
			return null;
		}
	}
	
	ExprInfo Assemble(BinaryExpr expr, RelationalOp op, Function func) {
		ExprInfo left = generateExpr(expr.left, func, false);
		ExprInfo right = generateExpr(expr.right, func, false);
		
		if (left.value != null && right.value != null) {
			boolean ret;
			switch (op) {
			case EQ: ret = (left.value == right.value); break;
			case NE: ret = (left.value != right.value); break;
			case GT: ret = (left.value >  right.value); break;
			case GE: ret = (left.value >= right.value); break;
			case LT: ret = (left.value <  right.value); break;
			case LE: ret = (left.value <= right.value); break;
			default: ret = false;
			}
			if (ret == true) {
				return new ExprInfo(new IntType(), new IntegerConst(1), 1);
			} else {
				return new ExprInfo(new IntType(), new IntegerConst(0), 0);
			}
		}
		
		Temp temp = new Temp();
		
		Label label1 = new Label(), label2 = new Label();
		
		func.body.add(new IfTrueGoto(left.address, op, right.address, label1));
		func.body.add(new Assign(temp, new IntegerConst(0)));
		func.body.add(new Goto(label2));
		func.body.add(label1);
		func.body.add(new Assign(temp, new IntegerConst(1)));
		func.body.add(label2);
		
		return new ExprInfo(new IntType(), temp, null);
	}
	
	int getBaseType(Type type) {
		if (type instanceof PointerType) {
			return ((PointerType)type).baseType.getSize();
		} else if (type instanceof ArrayType) {
			return ((ArrayType)type).baseType.getSize();
		} else if (type instanceof StringType) {
			return 1;
		} else {
			throw new NullPointerException();
		}
	}
	
	ExprInfo generateBinaryExpr(BinaryExpr expr, Function func) {
		ExprInfo left = null, right = null;
		Temp temp;
		switch (expr.op) {
		case COMMA: left = generateExpr(expr.left, func, false);
					right = generateExpr(expr.right, func, false);
					return right;
		case ASSIGN:left = generateExpr(expr.left, func, true);
					right = generateExpr(expr.right, func, false);
					if (isArray(right.type)) {
						assignGenerate(left, right, func);
					} else {
						if (left.address instanceof Name) {
							func.body.add(new Assign(left.address, right.address));
						} else {
							func.body.add(new MemoryWrite(left.address, right.address, right.type.getSize()));
						}
					}
					return right;
		case ASSIGN_MUL:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = new Temp();
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MUL, right.address));
							func.body.add(new Assign(left.address, temp));
						} else {
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.MUL, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
						}
						return new ExprInfo(left.type, temp, null);
		case ASSIGN_DIV:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = new Temp();
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.DIV, right.address));
							func.body.add(new Assign(left.address, temp));
						} else {
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.DIV, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
						}
						return new ExprInfo(left.type, temp, null);
		case ASSIGN_MOD:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = new Temp();
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MOD, right.address));
							func.body.add(new Assign(left.address, temp));
						} else {
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.MOD, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
						}
						return new ExprInfo(left.type, temp, null);
		case ASSIGN_ADD:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = new Temp();
						Temp delta = new Temp();
						if (left.type instanceof PointerType || left.type instanceof ArrayType || left.type instanceof StringType) {
							func.body.add(new ArithmeticExpr(delta, right.address, ArithmeticOp.MUL,
									new IntegerConst(getBaseType(left.type))));
						} else {
							func.body.add(new Assign(delta, right.address));
						}
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.ADD, delta));
							func.body.add(new Assign(left.address, temp));
						} else {
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, delta));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
						}
						return new ExprInfo(left.type, temp, null);
		case ASSIGN_SUB:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.type instanceof PointerType && right.type instanceof PointerType) {
							temp = new Temp();
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MINUS, right.address));
							func.body.add(new ArithmeticExpr(left.address, temp, ArithmeticOp.DIV, new IntegerConst(getBaseType(left.type))));
							return new ExprInfo(new IntType(), left.address, null);
						}
						temp = new Temp();
						delta = new Temp();
						if (left.type instanceof PointerType || left.type instanceof ArrayType || left.type instanceof StringType) {
							func.body.add(new ArithmeticExpr(delta, right.address, ArithmeticOp.MUL, 
									new IntegerConst(getBaseType(left.type))));
						} else {
							func.body.add(new Assign(delta, right.address));
						}
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.MINUS, delta));
							return new ExprInfo(left.type, left.address, null);
						} else {
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.MINUS, delta));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new ExprInfo(left.type, temp, null);
						}
		case ASSIGN_SHL:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.SHL, right.address));
							return new ExprInfo(left.type, left.address, null);
						} else {
							temp = new Temp();
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.SHL, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new ExprInfo(left.type, temp, null);
						}
		case ASSIGN_SHR:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.SHR, right.address));
							return new ExprInfo(left.type, left.address, null);
						} else {
							temp = new Temp();
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.SHR, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new ExprInfo(left.type, temp, null);
						}
		case ASSIGN_AND:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.AND, right.address));
							return new ExprInfo(left.type, left.address, null);
						} else {
							temp = new Temp();
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.AND, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new ExprInfo(left.type, temp, null);
						}
		case ASSIGN_XOR:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.XOR, right.address));
							return new ExprInfo(left.type, left.address, null);
						} else {
							temp = new Temp();
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.XOR, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new ExprInfo(left.type, temp, null);
						}
		case ASSIGN_OR: left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.OR, right.address));
							return new ExprInfo(left.type, left.address, null);
						} else {
							temp = new Temp();
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.OR, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new ExprInfo(left.type, temp, null);
						}
		
		case LOGICAL_OR:temp = new Temp();
						left = generateExpr(expr.left, func, false);
						if (left.value != null && left.value != 0) {
							return new ExprInfo(new IntType(), new IntegerConst(1), 1);
						}
						Label label1 = new Label(), label2 = new Label();
						func.body.add(new IfTrueGoto(left.address, RelationalOp.NE, ZERO, label1));
						right = generateExpr(expr.right, func, false);
						if (right.value != null && right.value != 0) {
							return new ExprInfo(new IntType(), new IntegerConst(1), 1);
						}
						if (left.value != null && left.value == 0 && right.value != null && right.value == 0) {
							return new ExprInfo(new IntType(), new IntegerConst(0), 0);
						}
						
						func.body.add(new IfTrueGoto(right.address, RelationalOp.NE, ZERO, label1));
						func.body.add(new Assign(temp, new IntegerConst(0)));
						func.body.add(new Goto(label2));
						func.body.add(label1);
						func.body.add(new Assign(temp, new IntegerConst(1)));
						func.body.add(label2);
						return new ExprInfo(new IntType(), temp, null);
		case LOGICAL_AND:temp = new Temp();
						left = generateExpr(expr.left, func, false);
						if (left.value != null && left.value == 0) {
							return new ExprInfo(new IntType(), new IntegerConst(0), 0);
						}

						label1 = new Label();
						label2 = new Label();
						func.body.add(new IfTrueGoto(left.address, RelationalOp.EQ, ZERO, label1));
						right = generateExpr(expr.right, func, false);
						if (right.value != null && right.value == 0) {
							return new ExprInfo(new IntType(), new IntegerConst(0), 0);
						}
						if (left.value != null && left.value != 0 && right.value != null && right.value != 0) {
							return new ExprInfo(new IntType(), new IntegerConst(1), 1);
						}
						
						func.body.add(new IfTrueGoto(right.address, RelationalOp.EQ, ZERO, label1));
						func.body.add(new Assign(temp, new IntegerConst(1)));
						func.body.add(new Goto(label2));
						func.body.add(label1);
						func.body.add(new Assign(temp, new IntegerConst(0)));
						func.body.add(label2);
						return new ExprInfo(new IntType(), temp, null);
		case OR: 	    left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new ExprInfo(new IntType(), new IntegerConst(left.value | right.value), left.value | right.value);
						}
						temp = new Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.OR, right.address));
						func.body.add(new Assign(left.address, temp));
						return new ExprInfo(new IntType(), temp, null);
		case XOR:       left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new ExprInfo(new IntType(), new IntegerConst(left.value ^ right.value), left.value ^ right.value);
						}
						temp = new Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.XOR, right.address));
						func.body.add(new Assign(left.address, temp));
						return new ExprInfo(new IntType(), temp, null);
		case AND:       left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new ExprInfo(new IntType(), new IntegerConst(left.value & right.value), left.value & right.value);
						}
						temp = new Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.AND, right.address));
						func.body.add(new Assign(left.address, temp));
						return new ExprInfo(new IntType(), temp, null);
		case EQ:        return Assemble(expr, RelationalOp.EQ, func);
		case NE:		return Assemble(expr, RelationalOp.NE, func);
		case LT:		return Assemble(expr, RelationalOp.LT, func);
		case GT:		return Assemble(expr, RelationalOp.GT, func);
		case LE:		return Assemble(expr, RelationalOp.LE, func);
		case GE: 		return Assemble(expr, RelationalOp.GE, func);
		case SHL:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new ExprInfo(new IntType(), new IntegerConst(left.value << right.value), left.value << right.value);
						}
						temp = new Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SHL, right.address));
						return new ExprInfo(new IntType(), temp, null);
		case SHR:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new ExprInfo(new IntType(), new IntegerConst(left.value >> right.value), left.value >> right.value);
						}
						temp = new Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SHR, right.address));
						return new ExprInfo(new IntType(), temp, null);
		case ADD:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if ((left.type instanceof IntType || left.type instanceof CharType) 
								&& (right.type instanceof IntType || right.type instanceof CharType)) {
							if (left.value != null && right.value != null) {
								return new ExprInfo(new IntType(), new IntegerConst(left.value + right.value), left.value + right.value);
							}
							temp = new Temp();
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.ADD, right.address));
							return new ExprInfo(new IntType(), temp, null);
						} else {
							temp = new Temp();
							func.body.add(new ArithmeticExpr(temp, right.address, ArithmeticOp.MUL,
									new IntegerConst(getBaseType(left.type))));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, left.address));
							return new ExprInfo(left.type, temp, null);
						}
		case SUB:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						temp = new Temp();
						if ((left.type instanceof IntType || left.type instanceof CharType) 
								&& (right.type instanceof IntType || right.type instanceof CharType)) {
							if (left.value != null && right.value != null) {
								return new ExprInfo(new IntType(), temp, left.value - right.value);
							} else {
								func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MINUS, right.address));
								return new ExprInfo(new IntType(), temp, null);
							}
						} else if (right.type instanceof IntType || right.type instanceof CharType){
							func.body.add(new ArithmeticExpr(temp, right.address, ArithmeticOp.MUL, 
									new IntegerConst(getBaseType(left.type))));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, left.address));
							return new ExprInfo(left.type, temp, null);
						} else {
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MINUS, right.address));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.DIV, new IntegerConst(getBaseType(left.type))));
							func.body.add(new Assign(left.address, temp));
							return new ExprInfo(new IntType(), temp, null);
						}
		case MUL:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new ExprInfo(new IntType(), new IntegerConst(left.value * right.value), left.value * right.value);
						}
						temp = new Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MUL, right.address));
						return new ExprInfo(new IntType(), temp, null);
		case DIV:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new ExprInfo(new IntType(), new IntegerConst(left.value / right.value), left.value / right.value);
						}
						temp = new Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.DIV, right.address));
						return new ExprInfo(new IntType(), temp, null);
		case MOD:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new ExprInfo(new IntType(), new IntegerConst(left.value % right.value), left.value % right.value);
						}
						temp = new Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MOD, right.address));
						return new ExprInfo(new IntType(), temp, null);
		}
		return null;
	}
	
	ExprInfo generateUnaryExpr(UnaryExpr expr, Function func, boolean isLeft) {
		ExprInfo info = null;
		switch (expr.op) {
		case INC:   info = generateExpr(expr.expr, func, true);
					if (info.type instanceof PointerType) {
						func.body.add(new ArithmeticExpr(info.address, info.address, ArithmeticOp.ADD, 
								new IntegerConst(getBaseType(info.type))));
					} else {
						func.body.add(new ArithmeticExpr(info.address, info.address, ArithmeticOp.ADD, new IntegerConst(1)));
					}
					return info;
		case DEC:   info = generateExpr(expr.expr, func, true);
					if (info.type instanceof PointerType) {
						func.body.add(new ArithmeticExpr(info.address, info.address, ArithmeticOp.MINUS, 
								new IntegerConst(getBaseType(info.type))));
					} else {
						func.body.add(new ArithmeticExpr(info.address, info.address, ArithmeticOp.MINUS, new IntegerConst(1)));
					}
					return info;
		case SIZEOF:info = generateExpr(expr.expr, func, false);
					return new ExprInfo(new IntType(), new IntegerConst(info.type.getSize()), info.type.getSize());
		case AMPERSAND: info = generateExpr(expr.expr, func, true);
					if (info.address instanceof Name) {
						Temp temp = new Temp();
						func.body.add(new AddressOf(temp, (Name)(info.address)));
						return new ExprInfo(new PointerType(info.type), temp, null);
					} else {
						return new ExprInfo(new PointerType(info.type), info.address, null);
					}
		case ASTERISK: 
					if (isLeft) {
						info = generateExpr(expr.expr, func, false);
						return info;
					} else {
						info = generateExpr(expr.expr, func, false);
						Temp temp = new Temp();
						if (info.type instanceof ArrayType) {
							Type baseType = ((ArrayType)info.type).baseType;
							if (isArray(baseType) == false) {
								func.body.add(new MemoryRead(temp, info.address, baseType.getSize()));
								return new ExprInfo(baseType, temp, null);
							} else {
								return new ExprInfo(baseType, info.address, null);
							}
						} else if (info.type instanceof PointerType) {
							Type baseType = ((PointerType)info.type).baseType;
							if (isArray(baseType) == false) {
								func.body.add(new MemoryRead(temp, info.address, baseType.getSize()));
								return new ExprInfo(baseType, temp, null);
							} else {
								return new ExprInfo(baseType, info.address, null);
							}
						} else if (info.type instanceof StringType) {
							return new ExprInfo(new CharType(), info.address, null);
						}
					}
		case PLUS:  info = generateExpr(expr.expr, func, isLeft);
					return info;
		case MINUS: info = generateExpr(expr.expr, func, isLeft);
					if (info.value != null) {
						return new ExprInfo(info.type, new IntegerConst(-info.value), -info.value);
					} else {
						Temp t1 = new Temp();
						func.body.add(new ArithmeticExpr(t1, ArithmeticOp.MINUS, info.address));
						return new ExprInfo(info.type, t1, -info.value);
					}
		case TILDE: info = generateExpr(expr.expr, func, isLeft);
					if (info.value != null) {
						return new ExprInfo(info.type, new IntegerConst(~info.value), ~info.value);
					} else {
						Temp t2 = new Temp();
						func.body.add(new ArithmeticExpr(t2, ArithmeticOp.TILDE, info.address));
						return new ExprInfo(info.type, t2, ~info.value);
					}
		case NOT:   info = generateExpr(expr.expr, func, isLeft);
					if (info.value != null) {
						if (info.value == 0) {
							return new ExprInfo(new IntType(), new IntegerConst(1), 1);
						} else {
							return new ExprInfo(new IntType(), new IntegerConst(0), 0);
						}
					} else {
						Temp t3 = new Temp();
						Label label1 = new Label();
						Label label2 = new Label();
						func.body.add(new IfFalseGoto(info.address, RelationalOp.EQ, ZERO, label1));
						func.body.add(new Assign(t3, new IntegerConst(1)));
						func.body.add(new Goto(label2));
						func.body.add(label1);
						func.body.add(new Assign(t3, ZERO));
						func.body.add(label2);
						return new ExprInfo(new IntType(), t3, null);
					}
		}
		return null;
	}
	
	ExprInfo generateSizeofExpr(SizeofExpr expr, Function func) {
		return new ExprInfo(expr.type, new IntegerConst(expr.type.getSize()), expr.type.getSize());
	}
		
	ExprInfo generateCastExpr(CastExpr expr, Function func, boolean isLeft) {
		ExprInfo info = generateExpr(expr.expr, func, isLeft);
		return new ExprInfo(expr.cast, info.address, info.value);
	}
	
	ExprInfo generatePointerAccess(PointerAccess expr, Function func, boolean isLeft) {
		ExprInfo body = generateExpr(expr.body, func, false);
		
		Type type = body.type;
		if (type instanceof ArrayType) {
			type = new PointerType(((ArrayType) type).baseType);
		} else {
			// type must be PointerType)
		}
		Type base = ((PointerType)type).baseType;
		if (base instanceof StructType) {
			StructDecl decl = (StructDecl)(env.getByType(((StructType)base).tag));
			int delta = 0;
			for (VarDecl it : decl.fields) {
				if (expr.attribute == it.name) {
					Temp temp = new Temp();
					func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(delta)));
					if (isLeft || isArray(it.type)) {
						return new ExprInfo(it.type, temp, null);
					} else {
						//func.body.add(new ArrayRead(temp2, (Name)(body.address), temp, it.type.getSize()));
						Temp temp2 = new Temp();
						func.body.add(new MemoryRead(temp2, temp, it.type.getSize()));
						return new ExprInfo(it.type, temp2, null);
					}
				} else {
					delta += it.type.getSize();
				}
			}
			
		} else if (base instanceof UnionType) {
			Object tmp = env.getByType(((UnionType)base).tag);
			UnionDecl decl = (UnionDecl)tmp;
			for (VarDecl it : decl.fields) {
				if (expr.attribute == it.name) {
					if (isLeft || isArray(it.type)) {
						return new ExprInfo(it.type, body.address, null);
					} else {
						Temp temp = new Temp();
						func.body.add(new MemoryRead(temp, body.address, it.type.getSize()));
						return new ExprInfo(it.type, temp, null);
					}
				}
			}
		} else {
			throw new NullPointerException();
		}
		return null;
	}
	
	ExprInfo generateRecordAccess(RecordAccess expr, Function func, boolean isLeft) {
		ExprInfo body = generateExpr(expr.body, func, true);
		
		Type type = body.type;
		if (type instanceof StructType) {
			StructDecl decl = (StructDecl)(env.getByType(((StructType)type).tag));
			int delta = 0;
			for (VarDecl it : decl.fields) {
				if (it.name == expr.attribute) {
					Temp temp = new Temp();
					func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(delta)));
					if (isLeft || isArray(it.type)) {
						return new ExprInfo(it.type, temp, 0);
					} else {
						Temp temp2 = new Temp();
						//func.body.add(new ArrayRead(temp2, (Name)(body.address), temp, it.type.getSize()));
						func.body.add(new MemoryWrite(temp2, temp, it.type.getSize()));
						return new ExprInfo(it.type, temp2, 0);
					}
				} else {
					delta += it.type.getSize();
				}
			}
		} else if (type instanceof UnionType) {
			UnionDecl decl = (UnionDecl)(env.getByType(((UnionType)type).tag));
			for (VarDecl it : decl.fields) {
				if (it.name == expr.attribute) {
					if (isLeft || isArray(it.type)) {
						return new ExprInfo(it.type, body.address, 0);
					} else {
						Temp temp = new Temp();
						func.body.add(new MemoryWrite(temp, body.address, it.type.getSize()));
						return new ExprInfo(it.type, temp, 0);
					}
				}
			}
		} else {
			throw new NullPointerException();
		}
		return null;
	}
	
	ExprInfo generateSelfIncrement(SelfIncrement expr, Function func) {
		//a++
		ExprInfo info = generateExpr(expr.body, func, true);
		Type type = info.type;
		Temp temp = new Temp();
		func.body.add(new Assign(temp, info.address));
		if (type instanceof IntType || type instanceof CharType) {
			func.body.add(new ArithmeticExpr(info.address, info.address, ArithmeticOp.ADD, new IntegerConst(1)));
		} else if (type instanceof PointerType) {
			func.body.add(new ArithmeticExpr(info.address, info.address, ArithmeticOp.ADD, new IntegerConst(4)));
		}
		return new ExprInfo(type, temp, 0);
	}
	
	ExprInfo generateSelfDecrement(SelfDecrement expr, Function func) {
		// a--
		ExprInfo info = generateExpr(expr.body, func, true);
		Type type = info.type;
		Temp temp = new Temp();
		func.body.add(new Assign(temp, info.address));
		if (type instanceof IntType || type instanceof CharType) {
			func.body.add(new ArithmeticExpr(info.address, info.address, ArithmeticOp.MINUS, new IntegerConst(1)));
		} else if (type instanceof PointerType) {
			func.body.add(new ArithmeticExpr(info.address, info.address, ArithmeticOp.MINUS, new IntegerConst(4)));
		}
		return new ExprInfo(type, temp, 0);		
	}
	
	ExprInfo generateArrayAccess(ArrayAccess expr, Function func, boolean isLeft) {
		ExprInfo body = generateExpr(expr.body, func, isLeft);
		
		Type base = null;
		if (body.type instanceof ArrayType) {
			base = ((ArrayType)body.type).baseType;
		} else if (body.type instanceof PointerType) {
			base = ((PointerType)body.type).baseType;
		} else if (body.type instanceof StringType) {
			base = new CharType();
		} else {
			System.err.println("fuck!");
		}
		
		ExprInfo sub = generateExpr(expr.subscript, func, false);
		// imporvable! 
		Temp temp = new Temp();
		func.body.add(new ArithmeticExpr(temp, sub.address, ArithmeticOp.MUL, new IntegerConst(base.getSize())));
		func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, temp));
		if (isLeft || isArray(base)) {
			return new ExprInfo(base, temp, 0);
		} else {
			func.body.add(new MemoryWrite(temp, temp, base.getSize()));
			return new ExprInfo(base, temp, 0);
		}
	}
	
	ExprInfo generateFunctionCall(FunctionCall expr, Function func) {
		// print
		// getchar
		// malloc
		
		FunctionDecl function = (FunctionDecl)(env.getByIden(expr.body));
		List<VarDecl> params = function.params;
		List<Param> paramList = new LinkedList<Param>();
		for (int i = 0; i < params.size(); i++) {
			ExprInfo info = generateExpr(expr.args.get(i), func, false);
			//Type t = params.get(i).type;
			if (isArray(info.type)) {
				paramList.add(new MemoryParam(info.address, info.type.getSize()));
			} else {
				paramList.add(new BasicParam(info.address));
			}
		}
		
		for (Param p : paramList) {
			func.body.add(p);
		}
		Temp temp = new Temp();
		if (isArray(function.returnType)) {
			func.body.add(new Call(new MemoryParam(temp, function.returnType.getSize()), function.name.toString(), paramList.size()));
		} else {
			func.body.add(new Call(new BasicParam(temp), function.name.toString(), paramList.size()));
		}
		
		return new ExprInfo(function.returnType, temp, null);
	}
	
	ExprInfo generateIdentifier(Identifier expr, Function func, boolean isLeft) {
		Decl decl = (Decl)(env.getByIden(expr.symbol));
		Address address = env.getByAddr(expr.symbol);
		if (decl instanceof FunctionDecl) {
			System.err.println("fuck!");
			return null;
		} else if (decl instanceof VarDecl) {
			Type type = ((VarDecl)decl).type;
			return new ExprInfo(type, address, null);
		} else {
			System.err.println("Identifier Impossible!");
			return null;
		}
	}
	
}*/
