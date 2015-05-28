package compiler2015.intermediate;
/*
import java.util.*;

import compiler2015.ast.*;
import compiler2015.env.*;
import compiler2015.ir.*;

class Info {
	public Type type;
	public Address address;
	public Address offset;
	public Integer value;
	
	Info(Type a, Address b, Address c, Integer d) {
		type = a;
		address = b;
		offset = c;
		value = d;
	}
};

public class Intermediate {
	
	IntegerConst ZERO = new IntegerConst(0);
	private int totalID = 0;
	
	private EnvironmentIR env;
	private LinkedList<Label> breakLabel, continueLabel;
	private int TEMP;
	private Function global;
	
	public Intermediate() {
		env = new EnvironmentIR();
		breakLabel = new LinkedList<Label>();
		continueLabel = new LinkedList<Label>();
//		TEMP = new Temp();
	}
	
	Name Temp() {
		++TEMP;
		Name n = new Name(new String("#" + TEMP));
		global.vars.add(new BasicVariable(n, 4));
		return n;
	}
	
	boolean isArray(Type type) {
		return type instanceof ArrayType || type instanceof StructType || type instanceof UnionType;
	}
	
	void assignGenerate(Info left, Info right, Function func) {
		if (!isArray(left.type)) {
			if (left.offset == null && right.offset == null) {
				func.body.add(new Assign(left.address, right.address));
			} else if (right.offset == null) {
				func.body.add(new ArrayWrite((Name)left.address, left.offset, right.address, right.type.getSize()));
			} else if (left.offset == null) {
				func.body.add(new ArrayRead(left.address, (Name)right.address, right.offset, right.type.getSize()));
			} else {
				Name temp = Temp();
				func.body.add(new ArrayRead(temp, (Name)right.address, right.offset, right.type.getSize()));
				func.body.add(new ArrayWrite((Name)left.address, left.offset, temp, right.type.getSize()));
			}
			return ;
		}
		
		// otherwise array assignment
		Name addr = Temp();
		Name temp = Temp();
		for (int i = 0; i < right.type.getSize(); i += 4) {
			if (right.offset instanceof IntegerConst) {
				func.body.add(new ArrayRead(temp, (Name)right.address, new IntegerConst(((IntegerConst)right.offset).value + i), 4));
			} else {
				func.body.add(new ArithmeticExpr(addr, right.offset, ArithmeticOp.ADD, new IntegerConst(i)));
				func.body.add(new ArrayRead(temp, (Name)right.address, addr, 4));
			}
			
			if (left.offset instanceof IntegerConst) {
				func.body.add(new ArrayWrite((Name)left.address, new IntegerConst(((IntegerConst)(left.offset)).value + i), temp, 4));
			} else {
				func.body.add(new ArithmeticExpr(addr, left.offset, ArithmeticOp.ADD, new IntegerConst(i)));
				func.body.add(new ArrayWrite((Name)left.address, addr, temp, 4));
			}
		}
	}
	
	public IR generateIR(AST ast) {
		List<Function> frags = new LinkedList<Function>();
		Function start = new Function("__start", 1);
		global = start;
		Type mainReturnType = null;
		for (Decl decl : ast.decls) {
			if (!(decl instanceof FunctionDecl)) {
				Variable var = generateVar(decl, start);
				if (var != null) {
					start.vars.add(var);
				}
			} else {
				FunctionDecl temp = (FunctionDecl) decl;
				if (temp.name == Symbol.get("main")) {
					mainReturnType = temp.returnType;
				}
			}
		}
		
		Name temp = Temp();
		if (isArray(mainReturnType)) {
			start.body.add(new Call(new MemoryParam(temp, mainReturnType.getSize()), "main", 0));
		} else {
			start.body.add(new Call(new BasicParam(temp), "main", 0));
		}
		
		frags.add(start);
		
		for (Decl decl : ast.decls) {
			if (decl instanceof FunctionDecl) {
				FunctionDecl funcDecl = (FunctionDecl)decl;
				env.putIden(funcDecl.name, funcDecl);
			}
		}
		
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
		global = func;
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
				if (type instanceof StructType) {
					((StructType)type).sizeOf = ((StructDecl)(env.getByType(((StructType)type).tag))).sizeOf;
				} else if (type instanceof UnionType) {
					((UnionType)type).sizeOf = ((UnionDecl)(env.getByType(((UnionType)type).tag))).sizeOf;
				} else {
					((ArrayType)type).loadSize();
				}
				return new ArrayVariable(name, type.getSize()); 
			} else {
				return new BasicVariable(name, type.getSize());
			}
		} else {
			System.err.println("fuck");
			return null;
		}
	}
	
	public void generateInitializer(Name name, Type type, Initializer init, Function func, int pos) {
		if (init instanceof InitValue) {
			Info info = generateExpr(((InitValue)init).expr, func, false);
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
			} else {
				if (!isArray(((VarDecl)env.getByIden(Symbol.get(name.name))).type)) {
					assignGenerate(new Info(type, name, null, null), info, func);
				} else {
					assignGenerate(new Info(type, name, new IntegerConst(pos), null), info, func);
				}
			}
		} else {
			// init must be InitList type
			InitList desc = (InitList)init;
			if (desc.inits.size() == 1 && desc.inits.get(0) instanceof InitValue && 
					((InitValue)(desc.inits.get(0))).expr instanceof StringConst) {
				init = desc.inits.get(0);
				generateInitializer(name, type, init, func, pos);
				return ;
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
			Variable var = generateVar(decl, func);
			if (var != null) {
				func.vars.add(var);
			}
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
			func.body.add(new Goto(breakLabel.getLast()));
		} else if (stmt instanceof ContinueStmt) {
			func.body.add(new Goto(continueLabel.getLast()));
		} else if (stmt instanceof IfStmt) {
			// condition or alternative must be not array type
			IfStmt tmp = (IfStmt)stmt;
			Info info = generateExpr(tmp.condition, func, false);
			
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
			breakLabel.add(new Label());
			
			func.body.add(begin);
			if (tmp.init != null) {
				generateExpr(tmp.init, func, false);
			}
			if (tmp.condition != null) {
				Info info = generateExpr(tmp.condition, func, false);
				func.body.add(ifFalse(info.address, breakLabel.getLast()));
			}
			generateStmt(tmp.body, func);
			if (tmp.step != null) { 
				generateExpr(tmp.step, func, false);
			}
			func.body.add(new Goto(begin));
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
				Info info = generateExpr(tmp.condition, func, false);
				func.body.add(ifFalse(info.address, breakLabel.getLast()));
			}
			generateStmt(tmp.body, func);
			func.body.add(new Goto(begin));
			func.body.add(breakLabel.getLast());
			
			breakLabel.removeLast();
			continueLabel.removeLast();
		} else if (stmt instanceof ReturnStmt) {
			ReturnStmt tmp = (ReturnStmt)stmt;
			Info info = generateExpr(tmp.expr, func, false);
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
	
	public Info generateExpr(Expr expr, Function func, boolean isLeft) {
		if (expr instanceof EmptyExpr) {
			return new Info(new IntType(), new IntegerConst(1), null, null);
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
			return new Info(new IntType(), new IntegerConst(((IntConst)expr).value), null, ((IntConst)expr).value);
		} else if (expr instanceof CharConst) {
			return new Info(new CharType(), new IntegerConst(((CharConst)expr).value.charAt(0)), null, Integer.valueOf(((CharConst)expr).value.charAt(0)));
		} else if (expr instanceof StringConst) {
			String str = ((StringConst)expr).value;
			return new Info(new StringType(str.length()), new StringAddressConst(str), null, null);
		} else {
			System.err.println("Unknown Expression!");
			return null;
		}
	}
	
	Info Assemble(BinaryExpr expr, RelationalOp op, Function func) {
		Info left = generateExpr(expr.left, func, false);
		Info right = generateExpr(expr.right, func, false);
		
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
				return new Info(new IntType(), new IntegerConst(1), null, 1);
			} else {
				return new Info(new IntType(), new IntegerConst(0), null, 0);
			}
		}
		
		Name temp = Temp();
		
		Label label1 = new Label(), label2 = new Label();
		
		func.body.add(new IfTrueGoto(left.address, op, right.address, label1));
		func.body.add(new Assign(temp, new IntegerConst(0)));
		func.body.add(new Goto(label2));
		func.body.add(label1);
		func.body.add(new Assign(temp, new IntegerConst(1)));
		func.body.add(label2);
		
		return new Info(new IntType(), temp, null, null);
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
	
	Info generateBinaryExpr(BinaryExpr expr, Function func) {
		Info left = null, right = null;
		Name temp;
		switch (expr.op) {
		case COMMA: left = generateExpr(expr.left, func, false);
					right = generateExpr(expr.right, func, false);
					return right;
		case ASSIGN:left = generateExpr(expr.left, func, true);
					right = generateExpr(expr.right, func, false);
					assignGenerate(left, right, func);
					return right;
		case ASSIGN_MUL:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MUL, right.address));
							func.body.add(new Assign(left.address, temp));
						} else {
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.MUL, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
						}
						return new Info(left.type, temp, null, null);
		case ASSIGN_DIV:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.DIV, right.address));
							func.body.add(new Assign(left.address, temp));
						} else {
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.DIV, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
						}
						return new Info(left.type, temp, null, null);
		case ASSIGN_MOD:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MOD, right.address));
							func.body.add(new Assign(left.address, temp));
						} else {
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.MOD, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
						}
						return new Info(left.type, temp, null, null);
		case ASSIGN_ADD:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						Name delta = Temp();
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
						return new Info(left.type, temp, null, null);
		case ASSIGN_SUB:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.type instanceof PointerType && right.type instanceof PointerType) {
							temp = Temp();
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SUB, right.address));
							func.body.add(new ArithmeticExpr(left.address, temp, ArithmeticOp.DIV, new IntegerConst(getBaseType(left.type))));
							return new Info(new IntType(), left.address, null, null);
						}
						temp = Temp();
						delta = Temp();
						if (left.type instanceof PointerType || left.type instanceof ArrayType || left.type instanceof StringType) {
							func.body.add(new ArithmeticExpr(delta, right.address, ArithmeticOp.MUL, 
									new IntegerConst(getBaseType(left.type))));
						} else {
							func.body.add(new Assign(delta, right.address));
						}
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.SUB, delta));
							return new Info(left.type, left.address, null, null);
						} else {
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.SUB, delta));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new Info(left.type, temp, null, null);
						}
		case ASSIGN_SHL:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.SHL, right.address));
							return new Info(left.type, left.address, null, null);
						} else {
							temp = Temp();
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.SHL, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new Info(left.type, temp, null, null);
						}
		case ASSIGN_SHR:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.SHR, right.address));
							return new Info(left.type, left.address, null, null);
						} else {
							temp = Temp();
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.SHR, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new Info(left.type, temp, null, null);
						}
		case ASSIGN_AND:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.AND, right.address));
							return new Info(left.type, left.address, null, null);
						} else {
							temp = Temp();
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.AND, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new Info(left.type, temp, null, null);
						}
		case ASSIGN_XOR:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.XOR, right.address));
							return new Info(left.type, left.address, null, null);
						} else {
							temp = Temp();
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.XOR, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new Info(left.type, temp, null, null);
						}
		case ASSIGN_OR: left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.address instanceof Name) {
							func.body.add(new ArithmeticExpr(left.address, left.address, ArithmeticOp.OR, right.address));
							return new Info(left.type, left.address, null, null);
						} else {
							temp = Temp();
							func.body.add(new MemoryRead(temp, left.address, left.type.getSize()));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.OR, right.address));
							func.body.add(new MemoryWrite(left.address, temp, left.type.getSize()));
							return new Info(left.type, temp, null, null);
						}
		
		case LOGICAL_OR:temp = Temp();
						left = generateExpr(expr.left, func, false);
						if (left.value != null && left.value != 0) {
							return new Info(new IntType(), new IntegerConst(1), null, 1);
						}
						Label label1 = new Label(), label2 = new Label();
						func.body.add(new IfTrueGoto(left.address, RelationalOp.NE, ZERO, label1));
						right = generateExpr(expr.right, func, false);
						if (right.value != null && right.value != 0) {
							return new Info(new IntType(), new IntegerConst(1), null, 1);
						}
						if (left.value != null && left.value == 0 && right.value != null && right.value == 0) {
							return new Info(new IntType(), new IntegerConst(0), null, 0);
						}
						
						func.body.add(new IfTrueGoto(right.address, RelationalOp.NE, ZERO, label1));
						func.body.add(new Assign(temp, new IntegerConst(0)));
						func.body.add(new Goto(label2));
						func.body.add(label1);
						func.body.add(new Assign(temp, new IntegerConst(1)));
						func.body.add(label2);
						return new Info(new IntType(), temp, null, null);
		case LOGICAL_AND:temp = Temp();
						left = generateExpr(expr.left, func, false);
						if (left.value != null && left.value == 0) {
							return new Info(new IntType(), new IntegerConst(0), null, 0);
						}

						label1 = new Label();
						label2 = new Label();
						func.body.add(new IfTrueGoto(left.address, RelationalOp.EQ, ZERO, label1));
						right = generateExpr(expr.right, func, false);
						if (right.value != null && right.value == 0) {
							return new Info(new IntType(), new IntegerConst(0), null, 0);
						}
						if (left.value != null && left.value != 0 && right.value != null && right.value != 0) {
							return new Info(new IntType(), new IntegerConst(1), null, 1);
						}
						
						func.body.add(new IfTrueGoto(right.address, RelationalOp.EQ, ZERO, label1));
						func.body.add(new Assign(temp, new IntegerConst(1)));
						func.body.add(new Goto(label2));
						func.body.add(label1);
						func.body.add(new Assign(temp, new IntegerConst(0)));
						func.body.add(label2);
						return new Info(new IntType(), temp, null, null);
		case OR: 	    left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value | right.value), null, left.value | right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.OR, right.address));
						func.body.add(new Assign(left.address, temp));
						return new Info(new IntType(), temp, null, null);
		case XOR:       left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value ^ right.value), null, left.value ^ right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.XOR, right.address));
						func.body.add(new Assign(left.address, temp));
						return new Info(new IntType(), temp, null, null);
		case AND:       left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value & right.value), null, left.value & right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.AND, right.address));
						func.body.add(new Assign(left.address, temp));
						return new Info(new IntType(), temp, null, null);
		case EQ:        return Assemble(expr, RelationalOp.EQ, func);
		case NE:		return Assemble(expr, RelationalOp.NE, func);
		case LT:		return Assemble(expr, RelationalOp.LT, func);
		case GT:		return Assemble(expr, RelationalOp.GT, func);
		case LE:		return Assemble(expr, RelationalOp.LE, func);
		case GE: 		return Assemble(expr, RelationalOp.GE, func);
		case SHL:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value << right.value), null, left.value << right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SHL, right.address));
						return new Info(new IntType(), temp, null, null);
		case SHR:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value >> right.value), null, left.value >> right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SHR, right.address));
						return new Info(new IntType(), temp, null, null);
		case ADD:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if ((left.type instanceof IntType || left.type instanceof CharType) 
								&& (right.type instanceof IntType || right.type instanceof CharType)) {
							if (left.value != null && right.value != null) {
								return new Info(new IntType(), new IntegerConst(left.value + right.value), null, left.value + right.value);
							}
							temp = Temp();
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.ADD, right.address));
							return new Info(new IntType(), temp, null, null);
						} else {
							temp = Temp();
							func.body.add(new ArithmeticExpr(temp, right.address, ArithmeticOp.MUL,
									new IntegerConst(getBaseType(left.type))));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, left.address));
							return new Info(left.type, temp, null, null);
						}
		case SUB:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						if ((left.type instanceof IntType || left.type instanceof CharType) 
								&& (right.type instanceof IntType || right.type instanceof CharType)) {
							if (left.value != null && right.value != null) {
								return new Info(new IntType(), temp, null, left.value - right.value);
							} else {
								func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SUB, right.address));
								return new Info(new IntType(), temp, null, null);
							}
						} else if (right.type instanceof IntType || right.type instanceof CharType){
							func.body.add(new ArithmeticExpr(temp, right.address, ArithmeticOp.MUL, 
									new IntegerConst(getBaseType(left.type))));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, left.address));
							return new Info(left.type, temp, null, null);
						} else {
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SUB, right.address));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.DIV, new IntegerConst(getBaseType(left.type))));
							func.body.add(new Assign(left.address, temp));
							return new Info(new IntType(), temp, null, null);
						}
		case MUL:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value * right.value), null, left.value * right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MUL, right.address));
						return new Info(new IntType(), temp, null, null);
		case DIV:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value / right.value), null, left.value / right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.DIV, right.address));
						return new Info(new IntType(), temp, null, null);
		case MOD:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value % right.value), null, left.value % right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MOD, right.address));
						return new Info(new IntType(), temp, null, null);
		}
		return null;
	}
	
	Info generateUnaryExpr(UnaryExpr expr, Function func, boolean isLeft) {
		Info info = null;
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
						func.body.add(new ArithmeticExpr(info.address, info.address, ArithmeticOp.SUB, 
								new IntegerConst(getBaseType(info.type))));
					} else {
						func.body.add(new ArithmeticExpr(info.address, info.address, ArithmeticOp.SUB, new IntegerConst(1)));
					}
					return info;
		case SIZEOF:info = generateExpr(expr.expr, func, false);
					return new Info(new IntType(), new IntegerConst(info.type.getSize()), null, info.type.getSize());
		case AMPERSAND: info = generateExpr(expr.expr, func, true);
					if (info.address instanceof Name && info.offset == null) {
						Name temp = Temp();
						func.body.add(new AddressOf(temp, (Name)(info.address)));
						return new Info(new PointerType(info.type), temp, null, null);
					} else if (info.offset == null) {
						return new Info(new PointerType(info.type), info.address, null, null);
					} else {
						Name temp = Temp();
						func.body.add(new ArithmeticExpr(temp, info.address, ArithmeticOp.ADD, info.offset));
						return new Info(new PointerType(info.type), temp, null, null);
					}
		case ASTERISK: 
					if (isLeft) {
						info = generateExpr(expr.expr, func, false);
						return info;
					} else {
						info = generateExpr(expr.expr, func, false);
						Name temp = Temp();
						if (info.type instanceof ArrayType) {
							Type baseType = ((ArrayType)info.type).baseType;
							if (isArray(baseType) == false) {
								if (info.offset == null) {
									func.body.add(new MemoryRead(temp, info.address, baseType.getSize()));
								} else {
									func.body.add(new ArrayRead(temp, (Name)info.address, info.offset, baseType.getSize()));
								}
								return new Info(baseType, temp, null, null);
							} else {
								return new Info(baseType, info.address, info.offset, null);
							}
						} else if (info.type instanceof PointerType) {
							Type baseType = ((PointerType)info.type).baseType;
							if (isArray(baseType) == false) {
								if (info.offset == null) {
									func.body.add(new MemoryRead(temp, info.address, baseType.getSize()));
								} else {
									func.body.add(new ArrayRead(temp, (Name)info.address, info.offset, baseType.getSize()));
								}
								return new Info(baseType, temp, null, null);
							} else {
								return new Info(baseType, info.address, info.offset, null);
							}
						} else if (info.type instanceof StringType) {
							return new Info(new CharType(), info.address, info.offset, null);
						}
					}
		case PLUS:  info = generateExpr(expr.expr, func, isLeft);
					return info;
		case MINUS: info = generateExpr(expr.expr, func, isLeft);
					if (info.value != null) {
						return new Info(info.type, new IntegerConst(-info.value), null, -info.value);
					} else {
						Name t1 = Temp();
						func.body.add(new ArithmeticExpr(t1, ArithmeticOp.SUB, info.address));
						return new Info(info.type, t1, null, -info.value);
					}
		case TILDE: info = generateExpr(expr.expr, func, isLeft);
					if (info.value != null) {
						return new Info(info.type, new IntegerConst(~info.value), null, ~info.value);
					} else {
						Name t2 = Temp();
						func.body.add(new ArithmeticExpr(t2, ArithmeticOp.TILDE, info.address));
						return new Info(info.type, t2, null, null);
					}
		case NOT:   info = generateExpr(expr.expr, func, isLeft);
					if (info.value != null) {
						if (info.value == 0) {
							return new Info(new IntType(), new IntegerConst(1), null, 1);
						} else {
							return new Info(new IntType(), new IntegerConst(0), null, 0);
						}
					} else {
						Name t3 = Temp();
						Label label1 = new Label();
						Label label2 = new Label();
						func.body.add(new IfFalseGoto(info.address, RelationalOp.EQ, ZERO, label1));
						func.body.add(new Assign(t3, new IntegerConst(1)));
						func.body.add(new Goto(label2));
						func.body.add(label1);
						func.body.add(new Assign(t3, ZERO));
						func.body.add(label2);
						return new Info(new IntType(), t3, null, null);
					}
		}
		return null;
	}
	
	Info generateSizeofExpr(SizeofExpr expr, Function func) {
		return new Info(expr.type, new IntegerConst(expr.type.getSize()), null, expr.type.getSize());
	}
		
	Info generateCastExpr(CastExpr expr, Function func, boolean isLeft) {
		Info info = generateExpr(expr.expr, func, isLeft);
		return new Info(expr.cast, info.address, info.offset, info.value);
	}
	
	Info generatePointerAccess(PointerAccess expr, Function func, boolean isLeft) {
		Info body = generateExpr(expr.body, func, false);
		
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
					if (isLeft || isArray(it.type)) {
						Name temp = Temp();
						if (body.offset == null) {
							func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(delta)));
						} else {
							func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, body.offset));
							if (delta > 0) {
								func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, new IntegerConst(delta)));
							}
						}
						return new Info(it.type, temp, null, null);
					} else {
						//func.body.add(new ArrayRead(temp2, (Name)(body.address), temp, it.type.getSize()));
						Name temp2 = Temp();
						if (body.offset == null) {
							Name temp = Temp();
							func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(delta)));
							func.body.add(new MemoryRead(temp2, temp, it.type.getSize()));
						} else {
							if (body.offset instanceof IntegerConst) {
								func.body.add(new ArrayRead(temp2, (Name)body.address,  
										new IntegerConst(delta + ((IntegerConst)body.offset).value), it.type.getSize()));
							} else {	
								Name temp = Temp();
								func.body.add(new ArithmeticExpr(temp, body.offset, ArithmeticOp.ADD, new IntegerConst(delta)));
								func.body.add(new ArrayRead(temp2, (Name)body.address, temp, it.type.getSize()));
							}
						}
						return new Info(it.type, temp2, null, null);
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
						if (body.offset == null) {
							return new Info(it.type, body.address, null, null);
						} else {
							Name temp = Temp();
							func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, body.offset));
							return new Info(it.type, temp, null, null);
						}
					} else {
						Name temp = Temp();
						if (body.offset == null) {
							func.body.add(new MemoryRead(temp, body.address, it.type.getSize()));
							return new Info(it.type, temp, null, null);
						} else {
							func.body.add(new ArrayRead(temp, (Name)body.address, body.offset, it.type.getSize()));
							return new Info(it.type, temp, null, null);
						}
					}
				}
			}
		} else {
			throw new NullPointerException();
		}
		return null;
	}
	
	Info generateRecordAccess(RecordAccess expr, Function func, boolean isLeft) {
		Info body = generateExpr(expr.body, func, true);
		
		Type type = body.type;
		if (type instanceof StructType) {
			StructDecl decl = (StructDecl)(env.getByType(((StructType)type).tag));
			int delta = 0;
			for (VarDecl it : decl.fields) {
				if (it.name == expr.attribute) {
					if (isLeft || isArray(it.type)) {
						if (body.offset == null) {
							Name temp = Temp();
							func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(delta)));
							return new Info(it.type, temp, null, null);
						} else if (body.offset instanceof IntegerConst) {
							return new Info(it.type, body.address, new IntegerConst(delta + ((IntegerConst)body.offset).value), null);
						} else {
							Name offset = Temp();
							func.body.add(new ArithmeticExpr(offset, body.offset, ArithmeticOp.ADD, new IntegerConst(delta)));
							return new Info(it.type, body.address, offset, null);
						}
					} else {
						Name temp = Temp();
						if (body.offset == null) {
							func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(delta)));
							func.body.add(new MemoryRead(temp, temp, it.type.getSize()));
							return new Info(it.type, temp, null, null);
						} else if (body.offset instanceof IntegerConst) {
							func.body.add(new ArrayRead(temp, (Name)body.address, 
										new IntegerConst(delta + ((IntegerConst)body.offset).value), it.type.getSize()));
							return new Info(it.type, temp, null, null);
						} else {
							Name offset = Temp();
							func.body.add(new ArithmeticExpr(offset, body.offset, ArithmeticOp.ADD, new IntegerConst(delta)));
							func.body.add(new ArrayRead(temp, (Name)body.address, offset, it.type.getSize()));
							return new Info(it.type, temp, null, null);
						}
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
						return new Info(it.type, body.address, body.offset, 0);
					} else {
						Name temp = Temp();
						if (body.offset == null) {
							func.body.add(new MemoryRead(temp, body.address, it.type.getSize()));
						} else {
							func.body.add(new ArrayRead(temp, (Name)body.address, body.offset, it.type.getSize()));
						}
						return new Info(it.type, temp, null, 0);
					}
				}
			}
		} else {
			throw new NullPointerException();
		}
		return null;
	}
	
	Info generateSelfIncrement(SelfIncrement expr, Function func) {
		//a++
		Info info = generateExpr(expr.body, func, true);
		Type type = info.type;
		Name temp = Temp();
		if (info.offset != null) {
			func.body.add(new ArrayRead(temp, (Name)info.address, info.offset, info.type.getSize()));
			Name pos = Temp(), temp2 = Temp();
			func.body.add(new ArithmeticExpr(pos, info.address, ArithmeticOp.ADD, info.offset));
			if (type instanceof IntType || type instanceof CharType) {
				func.body.add(new ArithmeticExpr(temp2, temp, ArithmeticOp.ADD, new IntegerConst(1)));
			} else if (type instanceof PointerType) {
				func.body.add(new ArithmeticExpr(temp2, temp, ArithmeticOp.ADD, new IntegerConst(4)));
			}
			func.body.add(new MemoryWrite(pos, temp2, type.getSize()));
		} else {
			func.body.add(new Assign(temp, info.address));
			if (type instanceof IntType || type instanceof CharType) {
				func.body.add(new ArithmeticExpr(info.address, temp, ArithmeticOp.ADD, new IntegerConst(1)));
			} else if (type instanceof PointerType) {
				func.body.add(new ArithmeticExpr(info.address, temp, ArithmeticOp.ADD, new IntegerConst(4)));
			}
		} 
		return new Info(type, temp, null, 0);
	}
	
	Info generateSelfDecrement(SelfDecrement expr, Function func) {
		// a--
		Info info = generateExpr(expr.body, func, true);
		Type type = info.type;
		Name temp = Temp();
		if (info.offset != null) {
			func.body.add(new ArrayRead(temp, (Name)info.address, info.offset, info.type.getSize()));
			Name pos = Temp(), temp2 = Temp();
			func.body.add(new ArithmeticExpr(pos, info.address, ArithmeticOp.SUB, info.offset));
			if (type instanceof IntType || type instanceof CharType) {
				func.body.add(new ArithmeticExpr(temp2, temp, ArithmeticOp.SUB, new IntegerConst(1)));
			} else if (type instanceof PointerType) {
				func.body.add(new ArithmeticExpr(temp2, temp, ArithmeticOp.SUB, new IntegerConst(4)));
			}
			func.body.add(new MemoryWrite(pos, temp2, type.getSize()));
		} else {
			func.body.add(new Assign(temp, info.address));
			if (type instanceof IntType || type instanceof CharType) {
				func.body.add(new ArithmeticExpr(info.address, temp, ArithmeticOp.SUB, new IntegerConst(1)));
			} else if (type instanceof PointerType) {
				func.body.add(new ArithmeticExpr(info.address, temp, ArithmeticOp.SUB, new IntegerConst(4)));
			}
		}
		return new Info(type, temp, null, 0);		
	}
	
	Info generateArrayAccess(ArrayAccess expr, Function func, boolean isLeft) {
		Info body = generateExpr(expr.body, func, isLeft);
		
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
		
		Info sub = generateExpr(expr.subscript, func, false);
		// imporvable! 
		
		if (body.offset == null) {
			// sub can't be arrayType
			Name temp = Temp();
			if (sub.value != null) {
				func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(sub.value * base.getSize())));
			} else {
				Name temp2 = Temp();
				func.body.add(new ArithmeticExpr(temp2, sub.address, ArithmeticOp.MUL, new IntegerConst(base.getSize())));
				func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, temp2));
			}
			return new Info(base, temp, null, null);
		}
		
		if (sub.value != null && body.offset instanceof IntegerConst) {
			if (isLeft || isArray(base)) {
				return new Info(base, body.address, new IntegerConst(sub.value * base.getSize() + ((IntegerConst)body.offset).value), null);
			} else {
				Name temp = Temp();
				func.body.add(new ArrayRead(temp, (Name)body.address, 
						new IntegerConst(sub.value * base.getSize() + ((IntegerConst)body.offset).value), base.getSize()));
				return new Info(base, temp, null, null);
			}
		}
		
		Name temp = Temp();
		if (sub.value != null) {
			func.body.add(new ArithmeticExpr(temp, body.offset, ArithmeticOp.ADD, new IntegerConst(base.getSize() * sub.value)));
		} else {
			func.body.add(new ArithmeticExpr(temp, sub.address, ArithmeticOp.MUL, new IntegerConst(base.getSize())));
			func.body.add(new ArithmeticExpr(temp, body.offset, ArithmeticOp.ADD, temp));
		}
		if (isLeft || isArray(base)) {
			return new Info(base, body.address, temp, null);
		} else {
			func.body.add(new ArrayRead(temp, (Name)body.address, temp, base.getSize()));
			return new Info(base, temp, null, null);
		}
	}
	
	Info generateFunctionCall(FunctionCall expr, Function func) {
		// print
		// getchar
		// malloc
		//System.err.println(expr.body);
		FunctionDecl function = (FunctionDecl)(env.getByIden(expr.body));
		if (function == null) {
			function = new FunctionDecl(new VoidType(), expr.body, null, new CompoundStmt());
		}
		//System.err.println(expr.body == Symbol.get("getchar"));
		List<VarDecl> params = function.params;
		List<Param> paramList = new LinkedList<Param>();
		for (int i = 0; i < expr.args.size(); i++) {
			Info info = generateExpr(expr.args.get(i), func, false);
			Type t = info.type;
			if (params != null) {
				t = params.get(i).type;
			}
			if (t instanceof ArrayType) {
				paramList.add(new BasicParam(info.address)); // ??
			} else if (isArray(info.type)) {
				paramList.add(new MemoryParam(info.address, info.type.getSize()));
			} else {
				paramList.add(new BasicParam(info.address));
			}
		}
		
		for (Param p : paramList) {
			func.body.add(p);
		}
		if (isArray(function.returnType)) {
			Name name = new Name("__array" + totalID); totalID++;
			func.vars.add(new ArrayVariable(name, function.returnType.getSize()));
			func.body.add(new Call(new MemoryParam(name, function.returnType.getSize()), function.name.toString(), paramList.size()));
			return new Info(function.returnType, name, new IntegerConst(0), null);
		} else {
			Name temp = Temp();
			func.body.add(new Call(new BasicParam(temp), function.name.toString(), paramList.size()));
			return new Info(function.returnType, temp, null, null);
		}
		
	}
	
	Info generateIdentifier(Identifier expr, Function func, boolean isLeft) {
		Decl decl = (Decl)(env.getByIden(expr.symbol));
		Address address = env.getByAddr(expr.symbol);
		if (decl instanceof FunctionDecl) {
			System.err.println("fuck!");
			return null;
		} else if (decl instanceof VarDecl) {
			Type type = ((VarDecl)decl).type;
			if (isArray(type)) {
				return new Info(type, address, new IntegerConst(0), null);
			} else {
				return new Info(type, address, null, null);
			}
		} else {
			System.err.println("Identifier Impossible!");
			return null;
		}
	}
	
}
*/