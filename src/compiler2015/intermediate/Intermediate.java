package compiler2015.intermediate;

import java.util.*;

import compiler2015.ast.*;
import compiler2015.env.*;
import compiler2015.ir.*;

class Info {
	public Type type;
	public Address address;
	public Integer value;
	
	Info(Type a, Address b, Integer d) {
		type = a;
		address = b;
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
		Name n = new Name(new String("__Temp__" + TEMP));
		global.vars.add(new BasicVariable(n, 4));
		return n;
	}
	
	int getSize(Type type) {
		if (type instanceof IntType) {
			return 4;
		} else if (type instanceof CharType) {
			return 1;
		} else if (type instanceof VoidType) {
			return 1;
		} else if (type instanceof PointerType) {
			return 4;
		} else if (type instanceof ArrayType) {
			Type base = ((ArrayType)type).baseType;
			return ((ArrayType)type).size * getSize(base);
		} if (type instanceof StructType) {
			return ((StructDecl)(env.getByType(((StructType)type).tag))).sizeOf;
		} else if (type instanceof UnionType) {
			return ((UnionDecl)(env.getByType(((UnionType)type).tag))).sizeOf;
		} else {
			System.err.println("getSize wrong!");
		}
		return 1;
	}
	
	boolean isArray(Type type) {
		return type instanceof ArrayType || type instanceof StructType || type instanceof UnionType;
	}
	
	void assignGenerate(Info left, Info right, Function func) {
		if (!isArray(left.type)) {
			func.body.add(new MemoryWrite(left.address, right.address, getSize(left.type)));
			return ;
		}
		// otherwise array assignment
		Name addra = Temp(); func.body.add(new Assign(addra, left.address));
		Name addrb = Temp(); func.body.add(new Assign(addrb, right.address));
		Name temp = Temp();
		for (int i = 0; i < getSize(right.type); i += 4) {
			func.body.add(new MemoryRead(temp, addrb, 4));
			func.body.add(new MemoryWrite(addra, temp, 4));
			if (i + 4 < getSize(right.type)) {
				func.body.add(new ArithmeticExpr(addra, addra, ArithmeticOp.ADD, new IntegerConst(4)));
				func.body.add(new ArithmeticExpr(addrb, addrb, ArithmeticOp.ADD, new IntegerConst(4)));
			}
		}
	}
	
	public IR generateIR(AST ast) {
		List<Function> frags = new LinkedList<Function>();
		Function start = new Function("main", 0);
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
					temp.name = Symbol.get("Main");
				}
			}
		}
		
		Name temp = Temp();
		if (isArray(mainReturnType)) {
			start.body.add(new Call(new MemoryParam(temp, getSize(mainReturnType)), "Main", 0));
		} else {
			start.body.add(new Call(new BasicParam(temp), "Main", 0));
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
		Function func = new Function(funcDecl.name.toString(), getSize(funcDecl.returnType));
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
				tmp.sizeOf += getSize(var.type);
				tmp.sizeOf += (4 - (tmp.sizeOf % 4)) % 4;
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
				tmp.sizeOf = Math.max(tmp.sizeOf, getSize(var.type));
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
			if (type instanceof StructType || type instanceof UnionType) { 
				return new ArrayVariable(name, getSize(type)); 
			} else if (type instanceof ArrayType) {
				return new ArrayVariable(name, -getSize(type));
			} else {
				return new BasicVariable(name, getSize(type));
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
					Name temp = Temp();
					func.body.add(new AddressOf(temp, name));
					func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, new IntegerConst(pos)));
					func.body.add(new MemoryWrite(temp, info.address, 4));
					//func.body.add(new ArrayWrite(name, new IntegerConst(pos), info.address, 4));
				} else if (type instanceof ArrayType) {
					String str = ((StringAddressConst)(info.address)).value;
					Name temp = Temp();
					for (int i = 0; i < str.length(); i++) {
						func.body.add(new AddressOf(temp, name));
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, new IntegerConst(pos + i)));
						func.body.add(new MemoryWrite(temp, new IntegerConst(str.charAt(i)), 1));
						//func.body.add(new ArrayWrite(name, new IntegerConst(pos + i), new IntegerConst(str.charAt(i)), 1));
					}
				} else {
					System.err.println("fuck");
				}
			} else {
				if (!isArray(((VarDecl)env.getByIden(Symbol.get(name.name))).type)) {
					Name temp = Temp();
					func.body.add(new AddressOf(temp, name));
					assignGenerate(new Info(type, temp, null), info, func);
				} else {
					Name temp = Temp();
					func.body.add(new AddressOf(temp, name));
					func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, new IntegerConst(pos)));
					assignGenerate(new Info(type, temp, null), info, func);
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
				pos += getSize(descType);
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
			if (tmp.init != null) {
				generateExpr(tmp.init, func, false);
			}
			
			Label begin = new Label(), mid = new Label(), end = new Label();
			continueLabel.add(mid);
			breakLabel.add(end);
			func.body.add(begin);
			
			if (tmp.condition != null) {
				Info info = generateExpr(tmp.condition, func, false);
				if (info != null) {
					func.body.add(ifFalse(info.address, breakLabel.getLast()));
				}
			}
			generateStmt(tmp.body, func);
			func.body.add(mid);
			if (tmp.step != null) { 
				generateExpr(tmp.step, func, false);
			}
			func.body.add(new Goto(begin));
			func.body.add(end);
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
			if (info == null) {
				func.body.add(new Return(null));
			} else if (isArray(info.type)) {
				func.body.add(new Return(new MemoryParam(info.address, getSize(info.type))));
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
			return null;
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
			return new Info(new IntType(), new IntegerConst(((IntConst)expr).value), ((IntConst)expr).value);
		} else if (expr instanceof CharConst) {
			
			return new Info(new CharType(), new IntegerConst(((CharConst)expr).value), Integer.valueOf(((CharConst)expr).value));
		} else if (expr instanceof StringConst) {
			String str = ((StringConst)expr).value;
			return new Info(new StringType(str.length()), new StringAddressConst(str), null);
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
				return new Info(new IntType(), new IntegerConst(1), 1);
			} else {
				return new Info(new IntType(), new IntegerConst(0), 0);
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
		
		return new Info(new IntType(), temp, null);
	}
	
	int getBaseType(Type type) {
		if (type instanceof PointerType) {
			return getSize(((PointerType)type).baseType);
		} else if (type instanceof ArrayType) {
			return getSize(((ArrayType)type).baseType);
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
						func.body.add(new MemoryRead(temp, left.address, getSize(left.type)));
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.MUL, right.address));
						func.body.add(new MemoryWrite(left.address, temp, getSize(left.type)));
						return new Info(left.type, temp, null);
		case ASSIGN_DIV:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						func.body.add(new MemoryRead(temp, left.address, getSize(left.type)));
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.DIV, right.address));
						func.body.add(new MemoryWrite(left.address, temp, getSize(left.type)));
						return new Info(left.type, temp, null);
		case ASSIGN_MOD:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						func.body.add(new MemoryRead(temp, left.address, getSize(left.type)));
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.MOD, right.address));
						func.body.add(new MemoryWrite(left.address, temp, getSize(left.type)));
						return new Info(left.type, temp, null);
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
						
						func.body.add(new MemoryRead(temp, left.address, getSize(left.type)));
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, delta));
						func.body.add(new MemoryWrite(left.address, temp, getSize(left.type)));
						return new Info(left.type, temp, null);
		case ASSIGN_SUB:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						if (left.type instanceof PointerType && right.type instanceof PointerType) {
							temp = Temp();
							func.body.add(new MemoryRead(temp, left.address, getSize(left.type)));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.SUB, right.address));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.DIV, new IntegerConst(getBaseType(left.type))));
							func.body.add(new MemoryWrite(left.address, temp, getSize(left.type)));
							return new Info(new IntType(), temp, null);
						}
						temp = Temp();
						delta = Temp();
						if (left.type instanceof PointerType || left.type instanceof ArrayType || left.type instanceof StringType) {
							func.body.add(new ArithmeticExpr(delta, right.address, ArithmeticOp.MUL, 
									new IntegerConst(getBaseType(left.type))));
						} else {
							func.body.add(new Assign(delta, right.address));
						}
						func.body.add(new MemoryRead(temp, left.address, getSize(left.type)));
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.SUB, delta));
						func.body.add(new MemoryWrite(left.address, temp, getSize(left.type)));
						return new Info(left.type, temp, null);
		case ASSIGN_SHL:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						func.body.add(new MemoryRead(temp, left.address, getSize(left.type)));
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.SHL, right.address));
						func.body.add(new MemoryWrite(left.address, temp, getSize(left.type)));
						return new Info(left.type, temp, null);
		case ASSIGN_SHR:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						func.body.add(new MemoryRead(temp, left.address, getSize(left.type)));
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.SHR, right.address));
						func.body.add(new MemoryWrite(left.address, temp, getSize(left.type)));
						return new Info(left.type, temp, null);
		case ASSIGN_AND:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						func.body.add(new MemoryRead(temp, left.address, getSize(left.type)));
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.AND, right.address));
						func.body.add(new MemoryWrite(left.address, temp, getSize(left.type)));
						return new Info(left.type, temp, null);
		case ASSIGN_XOR:left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						func.body.add(new MemoryRead(temp, left.address, getSize(left.type)));
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.XOR, right.address));
						func.body.add(new MemoryWrite(left.address, temp, getSize(left.type)));
						return new Info(left.type, temp, null);
		case ASSIGN_OR: left = generateExpr(expr.left, func, true);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						func.body.add(new MemoryRead(temp, left.address, getSize(left.type)));
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.OR, right.address));
						func.body.add(new MemoryWrite(left.address, temp, getSize(left.type)));
						return new Info(left.type, temp, null);
		
		case LOGICAL_OR:temp = Temp();
						left = generateExpr(expr.left, func, false);
						if (left.value != null && left.value != 0) {
							return new Info(new IntType(), new IntegerConst(1), 1);
						}
						Label label1 = new Label(), label2 = new Label();
						func.body.add(new IfTrueGoto(left.address, RelationalOp.NE, ZERO, label1));
						right = generateExpr(expr.right, func, false);
						
						func.body.add(new IfTrueGoto(right.address, RelationalOp.NE, ZERO, label1));
						func.body.add(new Assign(temp, new IntegerConst(0)));
						func.body.add(new Goto(label2));
						func.body.add(label1);
						func.body.add(new Assign(temp, new IntegerConst(1)));
						func.body.add(label2);
						
						if (right.value != null && right.value != 0) {
							return new Info(new IntType(), new IntegerConst(1), 1);
						}
						if (left.value != null && left.value == 0 && right.value != null && right.value == 0) {
							return new Info(new IntType(), new IntegerConst(0), 0);
						}
						
						return new Info(new IntType(), temp, null);
		case LOGICAL_AND:temp = Temp();
						left = generateExpr(expr.left, func, false);
						if (left.value != null && left.value == 0) {
							return new Info(new IntType(), new IntegerConst(0), 0);
						}

						label1 = new Label();
						label2 = new Label();
						func.body.add(new IfTrueGoto(left.address, RelationalOp.EQ, ZERO, label1));
						right = generateExpr(expr.right, func, false);
						
						func.body.add(new IfTrueGoto(right.address, RelationalOp.EQ, ZERO, label1));
						func.body.add(new Assign(temp, new IntegerConst(1)));
						func.body.add(new Goto(label2));
						func.body.add(label1);
						func.body.add(new Assign(temp, new IntegerConst(0)));
						func.body.add(label2);
						
						if (right.value != null && right.value == 0) {
							return new Info(new IntType(), new IntegerConst(0), 0);
						}
						if (left.value != null && left.value != 0 && right.value != null && right.value != 0) {
							return new Info(new IntType(), new IntegerConst(1), 1);
						}
						
						return new Info(new IntType(), temp, null);
		case OR: 	    left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value | right.value), left.value | right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.OR, right.address));
						//func.body.add(new Assign(left.address, temp));
						return new Info(new IntType(), temp, null);
		case XOR:       left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value ^ right.value), left.value ^ right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.XOR, right.address));
						//func.body.add(new Assign(left.address, temp));
						return new Info(new IntType(), temp, null);
		case AND:       left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value & right.value), left.value & right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.AND, right.address));
						//func.body.add(new Assign(left.address, temp));
						return new Info(new IntType(), temp, null);
		case EQ:        return Assemble(expr, RelationalOp.EQ, func);
		case NE:		return Assemble(expr, RelationalOp.NE, func);
		case LT:		return Assemble(expr, RelationalOp.LT, func);
		case GT:		return Assemble(expr, RelationalOp.GT, func);
		case LE:		return Assemble(expr, RelationalOp.LE, func);
		case GE: 		return Assemble(expr, RelationalOp.GE, func);
		case SHL:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value << right.value), left.value << right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SHL, right.address));
						return new Info(new IntType(), temp, null);
		case SHR:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value >> right.value), left.value >> right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SHR, right.address));
						return new Info(new IntType(), temp, null);
		case ADD:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if ((left.type instanceof IntType || left.type instanceof CharType) 
								&& (right.type instanceof IntType || right.type instanceof CharType)) {
							if (left.value != null && right.value != null) {
								return new Info(new IntType(), new IntegerConst(left.value + right.value), left.value + right.value);
							}
							temp = Temp();
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.ADD, right.address));
							return new Info(new IntType(), temp, null);
						} else {
							temp = Temp();
							func.body.add(new ArithmeticExpr(temp, right.address, ArithmeticOp.MUL,
									new IntegerConst(getBaseType(left.type))));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, left.address));
							return new Info(left.type, temp, null);
						}
		case SUB:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						temp = Temp();
						if ((left.type instanceof IntType || left.type instanceof CharType) 
								&& (right.type instanceof IntType || right.type instanceof CharType)) {
							if (left.value != null && right.value != null) {
								return new Info(new IntType(), new IntegerConst(left.value - right.value), left.value - right.value);
							} else {
								func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SUB, right.address));
								return new Info(new IntType(), temp, null);
							}
						} else if (right.type instanceof IntType || right.type instanceof CharType){
							func.body.add(new ArithmeticExpr(temp, right.address, ArithmeticOp.MUL, 
									new IntegerConst(getBaseType(left.type))));
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SUB, temp));
							return new Info(left.type, temp, null);
						} else {
							func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.SUB, right.address));
							func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.DIV, new IntegerConst(getBaseType(left.type))));
							return new Info(new IntType(), temp, null);
						}
		case MUL:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value * right.value), left.value * right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MUL, right.address));
						return new Info(new IntType(), temp, null);
		case DIV:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value / right.value), left.value / right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.DIV, right.address));
						return new Info(new IntType(), temp, null);
		case MOD:		left = generateExpr(expr.left, func, false);
						right = generateExpr(expr.right, func, false);
						if (left.value != null && right.value != null) {
							return new Info(new IntType(), new IntegerConst(left.value % right.value), left.value % right.value);
						}
						temp = Temp();
						func.body.add(new ArithmeticExpr(temp, left.address, ArithmeticOp.MOD, right.address));
						return new Info(new IntType(), temp, null);
		}
		return null;
	}
	
	Info generateUnaryExpr(UnaryExpr expr, Function func, boolean isLeft) {
		Info info = null;
		Name temp;
		switch (expr.op) {
		case INC:   info = generateExpr(expr.expr, func, true);
					temp = Temp();
					func.body.add(new MemoryRead(temp, info.address, 4));
					if (info.type instanceof PointerType) {
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, 
								new IntegerConst(getBaseType(info.type))));
					} else {
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.ADD, new IntegerConst(1)));
					}
					func.body.add(new MemoryWrite(info.address, temp, 4));
					if (isLeft) {
						return info;
					} else {
						return new Info(info.type, temp, null);
					}
		case DEC:   info = generateExpr(expr.expr, func, true);
					temp = Temp();
					func.body.add(new MemoryRead(temp, info.address, 4));		
					if (info.type instanceof PointerType) {
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.SUB, 
								new IntegerConst(getBaseType(info.type))));
					} else {
						func.body.add(new ArithmeticExpr(temp, temp, ArithmeticOp.SUB, new IntegerConst(1)));
					}
					func.body.add(new MemoryWrite(info.address, temp, 4));
					if (isLeft) {
						return info;
					} else {
						return new Info(info.type, temp, null);
					}
		case SIZEOF:info = generateExpr(expr.expr, func, false);
					return new Info(new IntType(), new IntegerConst(getSize(info.type)), getSize(info.type));
		case AMPERSAND: info = generateExpr(expr.expr, func, true);
					temp = Temp();
					func.body.add(new Assign(temp, info.address));
					return new Info(new PointerType(info.type), temp, null);
		case ASTERISK: 
					info = generateExpr(expr.expr, func, false);
					temp = Temp();
					if (info.type instanceof ArrayType) {
						Type baseType = ((ArrayType)info.type).baseType;
						if (isLeft) {
							return new Info(baseType, info.address, null);
						} else if (isArray(baseType) == false) {
							func.body.add(new MemoryRead(temp, info.address, getSize(baseType)));
							return new Info(baseType, temp, null);
						} else {
							return new Info(baseType, info.address, null);
						}
					} else if (info.type instanceof PointerType) {
						Type baseType = ((PointerType)info.type).baseType;
						if (isLeft) {
							return new Info(baseType, info.address, null);
						} else if (isArray(baseType) == false) {
							func.body.add(new MemoryRead(temp, info.address, getSize(baseType)));
							return new Info(baseType, temp, null);
						} else {
							return new Info(baseType, info.address, null);
						}
					} else if (info.type instanceof StringType) {
						return new Info(new CharType(), info.address, null);
					}
		case PLUS:  info = generateExpr(expr.expr, func, isLeft);
					return info;
		case MINUS: info = generateExpr(expr.expr, func, isLeft);
					if (info.value != null) {
						return new Info(info.type, new IntegerConst(-info.value), -info.value);
					} else {
						Name t1 = Temp();
						func.body.add(new ArithmeticExpr(t1, ArithmeticOp.MINUS, info.address));
						return new Info(info.type, t1, null);
					}
		case TILDE: info = generateExpr(expr.expr, func, isLeft);
					if (info.value != null) {
						return new Info(info.type, new IntegerConst(~info.value), ~info.value);
					} else {
						Name t2 = Temp();
						func.body.add(new ArithmeticExpr(t2, ArithmeticOp.TILDE, info.address));
						return new Info(info.type, t2, null);
					}
		case NOT:   info = generateExpr(expr.expr, func, isLeft);
					if (info.value != null) {
						if (info.value == 0) {
							return new Info(new IntType(), new IntegerConst(1), 1);
						} else {
							return new Info(new IntType(), new IntegerConst(0), 0);
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
						return new Info(new IntType(), t3, null);
					}
		}
		return null;
	}
	
	Info generateSizeofExpr(SizeofExpr expr, Function func) {
		return new Info(new IntType(), new IntegerConst(getSize(expr.type)), getSize(expr.type));
	}
		
	Info generateCastExpr(CastExpr expr, Function func, boolean isLeft) {
		Info info = generateExpr(expr.expr, func, isLeft);
		return new Info(expr.cast, info.address, info.value);
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
						if (delta > 0) {
							func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(delta)));
						} else {
							func.body.add(new Assign(temp, body.address));
						}
						return new Info(it.type, temp, null);
					} else {
						//func.body.add(new ArrayRead(temp2, (Name)(body.address), temp, it.type.getSize()));
						Name temp = Temp();
						func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(delta)));
						func.body.add(new MemoryRead(temp, temp, getSize(it.type)));
						return new Info(it.type, temp, null);
					}
				} else {
					delta += getSize(it.type);
					delta += (4 - delta % 4) % 4;
				}
			}
			
		} else if (base instanceof UnionType) {
			Object tmp = env.getByType(((UnionType)base).tag);
			UnionDecl decl = (UnionDecl)tmp;
			for (VarDecl it : decl.fields) {
				if (expr.attribute == it.name) {
					if (isLeft || isArray(it.type)) {
						return new Info(it.type, body.address, null);
					} else {
						Name temp = Temp();
						func.body.add(new MemoryRead(temp, body.address, getSize(it.type)));
						return new Info(it.type, temp, null);
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
						Name temp = Temp();
						func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(delta)));
						return new Info(it.type, temp, null);
					} else {
						Name temp = Temp();
						func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(delta)));
						func.body.add(new MemoryRead(temp, temp, getSize(it.type)));
						return new Info(it.type, temp, null);
					}
				} else {
					delta += getSize(it.type);
					delta += (4 - delta % 4) % 4;
				}
			}
		} else if (type instanceof UnionType) {
			UnionDecl decl = (UnionDecl)(env.getByType(((UnionType)type).tag));
			for (VarDecl it : decl.fields) {
				if (it.name == expr.attribute) {
					if (isLeft || isArray(it.type)) {
						return new Info(it.type, body.address, null);
					} else {
						Name temp = Temp();
						func.body.add(new MemoryRead(temp, body.address, getSize(it.type)));
						return new Info(it.type, temp, null);
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
		Name temp = Temp(), temp2 = Temp();
		func.body.add(new MemoryRead(temp, info.address, getSize(info.type)));
		if (type instanceof IntType || type instanceof CharType) {
			func.body.add(new ArithmeticExpr(temp2, temp, ArithmeticOp.ADD, new IntegerConst(1)));
		} else {
			func.body.add(new ArithmeticExpr(temp2, temp, ArithmeticOp.ADD, new IntegerConst(4)));
		} 
		func.body.add(new MemoryWrite(info.address, temp2, getSize(info.type)));
		return new Info(type, temp, null);
	}
	
	Info generateSelfDecrement(SelfDecrement expr, Function func) {
		// a--
		Info info = generateExpr(expr.body, func, true);
		Type type = info.type;
		Name temp = Temp(), temp2 = Temp();
		func.body.add(new MemoryRead(temp, info.address, getSize(info.type)));
		if (type instanceof IntType || type instanceof CharType) {
			func.body.add(new ArithmeticExpr(temp2, temp, ArithmeticOp.SUB, new IntegerConst(1)));
		} else {
			func.body.add(new ArithmeticExpr(temp2, temp, ArithmeticOp.SUB, new IntegerConst(4)));
		} 
		func.body.add(new MemoryWrite(info.address, temp2, getSize(info.type)));
		return new Info(type, temp, null);		
	}
	
	Info generateArrayAccess(ArrayAccess expr, Function func, boolean isLeft) {
		Info body = generateExpr(expr.body, func, true);
		
		Type base = null;
		if (body.type instanceof ArrayType) {
			base = ((ArrayType)body.type).baseType;
		} else if (body.type instanceof PointerType) {
			base = ((PointerType)body.type).baseType;
			Name temp = Temp();
			func.body.add(new MemoryRead(temp, body.address, 4));
			body.address = temp;
		} else if (body.type instanceof StringType) {
			base = new CharType();
		} else {
			System.err.println("fuck!");
		}
		
		Info sub = generateExpr(expr.subscript, func, false);
		// improvable! 
		
			// sub can't be arrayType
		Name temp = Temp();
		if (sub.value != null) {
			func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, new IntegerConst(sub.value * getSize(base))));
		} else {
			func.body.add(new ArithmeticExpr(temp, sub.address, ArithmeticOp.MUL, new IntegerConst(getSize(base))));
			func.body.add(new ArithmeticExpr(temp, body.address, ArithmeticOp.ADD, temp));
		}
		
		if (isLeft == false && !isArray(base)) {
			if (base instanceof CharType) {
				func.body.add(new MemoryRead(temp, temp, 1));
			} else {
				func.body.add(new MemoryRead(temp, temp, 4));
			}
		}
		return new Info(base, temp, null);
	}
	
	Info generateFunctionCall(FunctionCall expr, Function func) {
		// print
		// getchar
		// malloc
		//System.err.println(expr.body);
		if (expr.body == Symbol.get("main")) {
			expr.body = Symbol.get("Main");
		}
		FunctionDecl function = (FunctionDecl)(env.getByIden(expr.body));
		if (function == null) {
			function = new FunctionDecl(null, expr.body, null, new CompoundStmt()); 
			if (expr.body == Symbol.get("malloc")) {
				function.returnType = new IntType();
			} else if (expr.body == Symbol.get("getchar")) {
				function.returnType = new CharType();
			} else if (expr.body == Symbol.get("printf")) {
				function.returnType = new VoidType();
			} else {
				throw new NullPointerException();
			}
		}
		//System.err.println(expr.body == Symbol.get("getchar"));
		List<VarDecl> params = function.params;
		List<Param> paramList = new LinkedList<Param>();
		for (int i = 0; i < expr.args.size(); i++) {
			Info info = generateExpr(expr.args.get(i), func, false);
			Type t = info.type;
			if (t instanceof ArrayType) {
				//System.err.println("array");
				Name temp = Temp();
				func.body.add(new Assign(temp, (Name)info.address));
				paramList.add(new BasicParam(temp)); // ??
			} else if (isArray(info.type)) {
				paramList.add(new MemoryParam(info.address, getSize(info.type)));
			} else {
				paramList.add(new BasicParam(info.address));
			}
		}
		
		if (expr.body == Symbol.get("malloc")) {
			Address address = ((BasicParam)paramList.get(0)).src;
			Name temp = Temp();
			if (address instanceof IntegerConst) {
				func.body.add(new MallocIntImmediate(((IntegerConst)address).value, temp));
			} else {
				func.body.add(new MallocInt((Name)address, temp));
			}
			return new Info(new IntType(), temp, null);
		}
		/*
		if (expr.body == Symbol.get("printf")) {
			String str = ((StringAddressConst)((BasicParam)paramList.get(0)).src).value;
			int ptr = 1;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '%') {
					Address address;
					switch (str.charAt(i + 1)) {
					case '%' : func.body.add(new PrintByte('%')); break;
					case 'd' : 
						address = ((BasicParam)paramList.get(ptr)).src;
						ptr++;
						if (address instanceof IntegerConst) {
							func.body.add(new PrintIntImmediate(((IntegerConst)address).value));
						} else {
							func.body.add(new PrintInt((Name)address));
						}
						break;
					case 'c' : 
						address = ((BasicParam)paramList.get(ptr)).src;
						ptr++;
						if (address instanceof IntegerConst) {
							func.body.add(new PrintByte(((IntegerConst)address).value));
						} else {
							func.body.add(new PrintChar((Name)address));
						}
						break;
					case 's' :
						address = ((BasicParam)paramList.get(ptr)).src;
						ptr++;
						if (address instanceof StringAddressConst) {
							func.body.add(new PrintStringImmediate(((StringAddressConst)address).value));
						} else {
							func.body.add(new PrintString((Name)address));
						}
						break;
					default : throw new NullPointerException();
					}
					i++;
				} else {
					func.body.add(new PrintByte(str.charAt(i)));
				}
			}
			Name temp = Temp();
			return new Info(new IntType(), temp, null);
		}
		*/
		for (Param p : paramList) {
			func.body.add(p);
		}
		if (function.returnType instanceof VoidType) {
			func.body.add(new Call(null, function.name.toString(), paramList.size()));
			return new Info(function.returnType, null, null);
		} else if (isArray(function.returnType)) {
			Name name = new Name("__array" + totalID); totalID++;
			func.vars.add(new ArrayVariable(name, getSize(function.returnType)));
			func.body.add(new Call(new MemoryParam(name, getSize(function.returnType)), function.name.toString(), paramList.size()));
			Name temp = Temp();
			func.body.add(new AddressOf(temp, name));
			return new Info(function.returnType, temp, null);
		} else {
			Name temp = Temp();
			func.body.add(new Call(new BasicParam(temp), function.name.toString(), paramList.size()));
			return new Info(function.returnType, temp, null);
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
			if (isLeft || isArray(type)) {
				Name temp = Temp();
				func.body.add(new AddressOf(temp, (Name)address));
				return new Info(type, temp, null);
			} else {
				return new Info(type, address, null);
			}
		} else {
			System.err.println("Identifier Impossible!");
			return null;
		}
	}
	
}
