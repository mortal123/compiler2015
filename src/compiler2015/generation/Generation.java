package compiler2015.generation;

import java.util.Dictionary;
import java.util.Hashtable;

import compiler2015.ir.*;
import compiler2015.register.*;

import java.lang.NullPointerException;

public class Generation {
	private String pre = "___";
	private int stringID = 0;
	public String newStringConst(String str) {
		board.addData("_str_" + stringID + ": .asciiz" + " \"" + str + "\"");
		stringID++;
		return "_str_" + (stringID - 1);
	}
	
	IR ir;
	public Board board = new Board();
	Naive reg;
	
	private Dictionary<Name, Integer> arg_array, sp_delta, local_size, global_size; 
	private int _function_size_;
    
    
	public Generation(IR _ir) {
		ir = _ir;
	}
	
	void error() {
		throw new NullPointerException();
	}
	
	void loadByGlobal(String regg, Name name, int offset) {
		board.addText("la " + reg.t2 + ", " + pre + name.name);
		if (global_size.get(name) == 1) {
			board.addText("li " + regg + ", 0");
			board.addText("lb " + regg + ", " + offset + "(" + reg.t2 + ")");
		} else {
			board.addText("lw " + regg + ", " + offset + "(" + reg.t2 + ")");
		}
	}
	
	void loadByStack(String reg, Name name, int offset) {
		if (local_size.get(name) == 1) {
			board.addText("li " + reg + ", 0");
			board.addText("lb " + reg + ", " + offset + "($sp)");
		} else {
			board.addText("lw " + reg + ", " + offset + "($sp)");
		}
	}
	
	public void loadByAddress(String reg, Address address) {
		if (address instanceof IntegerConst) {
			board.addText("li " + reg + ", " + ((IntegerConst)address).value);
		} else if (address instanceof StringAddressConst) {
			board.addText("la " + reg + ", " + newStringConst(((StringAddressConst)address).value));
		} else {
			Name name = (Name)address;
			if (sp_delta.get(name) == null) {
				loadByGlobal(reg, name, 0);
			} else {
				loadByStack(reg, name, -sp_delta.get(name) + _function_size_);
			}
		}
	}
	
	public void loadByMemory(String regg, String pos, int offset, int sz) {
		if (sz == 1) {
			if (regg == pos) {
				board.addText("move " + reg.t2 + ", " + pos);
				pos = reg.t2;
			}
			board.addText("li " + regg + ", 0");
			board.addText("lb " + regg + ", " + offset + "(" + pos + ")");
		} else {
			board.addText("lw " + regg + ", " + offset + "(" + pos + ")");
		}
	}
	
	public void loadAddress(String reg, Name name) {
		if (sp_delta.get(name) != null) {
			if (arg_array.get(name) != null) {
				board.addText("lw " + reg + ", " + (-sp_delta.get(name) + _function_size_) + "($sp)");
			} else {
				board.addText("add " + reg + ", " + "$sp, " + (-sp_delta.get(name) + _function_size_));
			}
		} else {
			board.addText("la " + reg + ", " + pre + name.name);
		}
	}
	
	void storeInStack(String reg, Name name, int offset) {
		if (local_size.get(name) == 1) {
			board.addText("sb " + reg + ", " + offset + "($sp)");
		} else {
			board.addText("sw " + reg + ", " + offset + "($sp)");
		}
	}
	
	void storeInGlobal(String regg, Name name, int offset) {
		board.addText("la " + reg.t2 + ", " + pre + name.name);
		if (global_size.get(name) == 1) {
			board.addText("sb " + regg + ", " + offset + "(" + reg.t2 + ")");
		} else {
			board.addText("sw " + regg + ", " + offset + "(" + reg.t2 + ")");
		}
	}
	
	void storeInAddress(String reg, Address address) {
		Name name = (Name)address;
		if (sp_delta.get(name) == null) {
			storeInGlobal(reg, name, 0);
		} else {
			storeInStack(reg, name, -sp_delta.get(name) + _function_size_);
		}
	}
	
	void storeInMemory(String reg, String pos, int offset, int sz) {
		if (sz == 1) {
			board.addText("sb " + reg + ", " + offset + "(" + pos + ")");
		} else {
			board.addText("sw " + reg + ", " + offset + "(" + pos + ")");
		}
	}
	
	public Board generate() {
		global_size = new Hashtable<Name, Integer>();
		reg = new Naive();
		
		for (Function func : ir.fragments) {
			board.addText(new String(""));
			boolean isStart = func.name.equals(new String("main"));
			if (isStart) {
				board.addText(func.name + ":");
			} else {
				board.addText(pre + func.name + ":");
			}
			int totalSize = 0;
			sp_delta = new Hashtable<Name, Integer>();
			local_size = new Hashtable<Name, Integer>();
			arg_array = new Hashtable<Name, Integer>();
			for (Variable arg : func.args) {
				if (arg.size < 0) {
					arg.size = 4;
					arg_array.put(arg.name, 1);
				}
				totalSize += arg.size;
				totalSize += (4 - totalSize % 4) % 4;
				sp_delta.put(arg.name, totalSize);
				local_size.put(arg.name, arg.size);
			}

			for (Variable var : func.vars) {
				if (var.size < 0) {
					var.size = -var.size;
				}
				if (isStart) {
					board.addData(pre + var.name.name + ": .space " + (var.size + 3) / 4 * 4);
					global_size.put(var.name, var.size);
				} else {
					totalSize += var.size;
					totalSize += (4 - totalSize % 4) % 4;
					sp_delta.put(var.name, totalSize);
					local_size.put(var.name, var.size);
				}
			}
			if (!isStart) {
				// ra
				totalSize += 4;
				board.addText(new String("add $sp, $sp, " + -totalSize));
				board.addText(new String("sw $ra, 0($sp)"));
			}
			
			_function_size_ = totalSize;
			
			int paramDelta = 0;
			
			for (Quadruple quad : func.body) {
				if (quad instanceof AddressOf) {
					AddressOf q = (AddressOf)quad;
					if (q.dest instanceof Name) {
						if (sp_delta.get((Name)q.src) == null) {
							board.addText("la " + reg.t0 + ", " + pre + ((Name)q.src).name);
							storeInAddress(reg.t0, q.dest);
						} else {
							loadAddress(reg.t0, q.src);
							storeInAddress(reg.t0, q.dest);
						}
					} else {
						error();
					}
				} else if (quad instanceof ArithmeticExpr) {
					ArithmeticExpr q = (ArithmeticExpr)quad;
					if (q.src2 == null) {
						loadByAddress(reg.t0, q.src1);
						String s = "";
						switch (q.op) {
						case MINUS : s = "sub " + reg.t0 + ", $zero, " + reg.t0; break;
						case TILDE : s = "nor " + reg.t0 + ", $zero, " + reg.t0; break;
						default : System.err.println(q.op); error();
						}
						board.addText(s);
						storeInAddress(reg.t0, q.dest);
					} else {
						String src1;
						if (q.src1 instanceof IntegerConst && q.op == ArithmeticOp.ADD) {
							src1 = ((IntegerConst)q.src1).value + "";
						} else {
							src1 = reg.t0;
							loadByAddress(src1, q.src1);
						}
						String src2;
						if (q.src2 instanceof IntegerConst && q.op == ArithmeticOp.ADD) {
							src2 = ((IntegerConst)q.src2).value + "";
						} else {
							src2 = reg.t1;
							loadByAddress(src2, q.src2);
						}
						
						if (q.op == ArithmeticOp.ADD) {
							if (src2.charAt(0) == '$') {
								String t = src1;
								src1 = src2;
								src2 = t;
							}
							if (src2.charAt(0) != '$') {
								board.addText("addiu " + reg.t0 + ", " + src1 + ", " + src2);
								storeInAddress(reg.t0, (Name)q.dest);
								continue;
							}
						}
						
						String dest = reg.t0;
						String s = "";
						switch (q.op) {
						case ADD : s = "add " + dest + ", " + src1 + ", " + src2; break;
						case SUB : s = "sub " + dest + ", " + src1 + ", " + src2; break;
						case MUL : s = "mul " + dest + ", " + src1 + ", " + src2; break;
						case DIV : s = "div " + dest + ", " + src1 + ", " + src2; break;
						case MOD : s = "rem " + dest + ", " + src1 + ", " + src2; break;
						case SHL : s = "sll " + dest + ", " + src1 + ", " + src2; break;
						case SHR : s = "srl " + dest + ", " + src1 + ", " + src2; break;
						case AND : s = "and " + dest + ", " + src1 + ", " + src2; break;
						case OR  : s =  "or " + dest + ", " + src1 + ", " + src2; break;
						case XOR : s = "xor " + dest + ", " + src1 + ", " + src2; break;
						default : System.err.println(q.op + " " + src1 + " " + src2); error();
						}
						board.addText(s);
						storeInAddress(dest, q.dest);
					}
				} else if (quad instanceof Param) {
					if (quad instanceof BasicParam) {
						BasicParam q = (BasicParam)quad;
						if (q.src instanceof IntegerConst) {
							paramDelta -= 4;
							board.addText("li " + reg.t0 + ", " + ((IntegerConst)q.src).value);
							board.addText("sw " + reg.t0 + ", " + paramDelta + "($sp)");
						} else if (q.src instanceof StringAddressConst) {
							paramDelta -= 4;
							String str = newStringConst(((StringAddressConst)q.src).value);
							board.addText("la " + reg.t3 + ", " + str);
							board.addText("sw " + reg.t3 + ", " + paramDelta + "($sp)");
						} else {
							paramDelta -= 4;
							loadByAddress(reg.t0, (Name)q.src);	
							board.addText("sw " + reg.t0 + ", " + paramDelta + "($sp)");
						}
					} else if (quad instanceof MemoryParam) {
						MemoryParam q = (MemoryParam)quad;
						paramDelta -= q.size;
						loadByAddress(reg.t0, (Name)q.src);
						for (int i = 0; i < q.size; i += 4) {
							board.addText("lw " + reg.t1 + ", " + i + "(" + reg.t0 + ")");
							//loadByAddress(reg.t0, (Name)q.src, i);
							board.addText("sw " + reg.t1 + ", " + (paramDelta + i)  + "($sp)");
						}
					} else {
						error();
					}
				} /*else if (quad instanceof ArrayRead) {
					ArrayRead q = (ArrayRead)quad;
					if (q.offset instanceof IntegerConst) {
						if (sp_delta.get((Name)q.src) != null) {
							loadByMemory(reg.t0, "$sp", 
									-sp_delta.get((Name)q.src) + _function_size_ + ((IntegerConst)q.offset).value, q.size);
						} else {
							loadByMemory(reg.t0, ((Name)q.src).name, ((IntegerConst)q.offset).value, q.size);
						}
					} else {
						loadByAddress(reg.t1, q.offset);
						if (sp_delta.get((Name)q.src) != null) {
							board.addText("add " + reg.t1 + ", " + reg.t1 + ", " + "$sp");
							loadByMemory(reg.t0, reg.t1, -sp_delta.get((Name)q.src) + _function_size_, q.size);
						} else {
							board.addText("la " + reg.t0 + ", " + pre + ((Name)q.src).name);
							board.addText("add " + reg.t0 + ", " + reg.t0 + ", " + reg.t1);
							loadByMemory(reg.t0, reg.t0, 0, q.size);
						}
					}
					storeInAddress(reg.t0, q.dest);
				} else if (quad instanceof ArrayWrite) {
					ArrayWrite q = (ArrayWrite)quad;
					if (q.offset instanceof IntegerConst) {
						if (sp_delta.get(q.dest) != null) {
							board.addText("addiu " + reg.t0 + ", " + "$sp" + ", " + 
									(-sp_delta.get(q.dest) + _function_size_ + ((IntegerConst)q.offset).value));
						} else {
							board.addText("la " + reg.t0 + ", " + pre + ((Name)q.dest).name);
							board.addText("addiu " + reg.t0 + ", " + reg.t0 + ", " + ((IntegerConst)q.offset).value);
						}
					} else {
						loadByAddress(reg.t1, q.offset);
						if (sp_delta.get(q.dest) != null) {
							board.addText("addiu " + reg.t0 + ", " + "$sp" + ", " + 
									(-sp_delta.get(q.dest) + _function_size_));
							board.addText("add " + reg.t0 + ", " + reg.t0 + ", " + reg.t1);
						} else {
							board.addText("la " + reg.t0 + ", " + pre + ((Name)q.dest).name);
							board.addText("add " + reg.t0 + ", " + reg.t0 + ", " + reg.t1);
						}
					}
					
					if (q.src instanceof IntegerConst) {
						board.addText("li " + reg.t1 + ", " + ((IntegerConst)q.src).value);
					} else {
						loadByAddress(reg.t1, q.src);
					}
					
					storeInMemory(reg.t1, reg.t0, 0, q.size);
				} */else if (quad instanceof Assign) {
					Assign q = (Assign)quad;
					if (q.src instanceof IntegerConst) {
						board.addText("li " + reg.t1 + ", " + ((IntegerConst)q.src).value);
						storeInAddress(reg.t1, q.dest);
					} else if (q.src instanceof StringAddressConst) {
						String str = ((StringAddressConst)q.src).value;
						board.addText("la " + reg.t0 + ", " + str);
						storeInAddress(reg.t0, q.dest);
					} else {
						loadByAddress(reg.t0, q.src);
						storeInAddress(reg.t0, q.dest);
					}
				} else if (quad instanceof Call) {
					Call q = (Call)quad;
					board.addText("jal " + pre + q.callee);
					Param ret = q.returnValue;
					if (ret == null) {
						
					} else if (ret instanceof BasicParam) {
						BasicParam r = (BasicParam)ret;
						if (r.src instanceof IntegerConst) {
							error();
							board.addText("li $v0, " + ((IntegerConst)r.src).value); 
						} else {
							storeInAddress("$v0", r.src);
						}
					} else if (ret instanceof MemoryParam) {
						MemoryParam r = (MemoryParam)ret;
						loadAddress(reg.t1, (Name)r.src);
						for (int i = 0; i < r.size; i += 4) {
							board.addText("lw " + reg.t0 + ", " + i + "($v0)");
							board.addText("sw " + reg.t0 + ", " + i + "(" + reg.t1 + ")");
						}
					} else {
						error();
					}
					paramDelta = 0;
				} else if (quad instanceof Goto) {
					Goto q = (Goto)quad;
					board.addText("j LABEL" + q.label.num);
				} else if (quad instanceof IfFalseGoto) {
					IfFalseGoto q = (IfFalseGoto)quad;
					String s = "";
					String left = reg.t0, right = reg.t1;
					if (q.src1 instanceof IntegerConst) {
						board.addText("li " + left + ", " + ((IntegerConst)q.src1).value);
					} else {
						loadByAddress(left, (Name)q.src1);
					}
					
					if (q.src2 instanceof IntegerConst) {
						board.addText("li " + right + ", " + ((IntegerConst)q.src2).value);
					} else {
						loadByAddress(right, (Name)q.src2);
					}
						
					switch (q.op) {
					case EQ : s = "bne " + left + ", " + right; break;
					case NE : s = "beq " + left + ", " + right; break;
					case GT : s = "ble " + left + ", " + right; break;
					case GE : s = "blt " + left + ", " + right; break;
					case LT : s = "bge " + left + ", " + right; break;
					case LE : s = "bgt " + left + ", " + right; break;
					default : error();
					}
					board.addText(s + ", LABEL" + q.label.num);
				} else if (quad instanceof IfTrueGoto) {
					IfTrueGoto q = (IfTrueGoto)quad;
					String s = "";
					String left = reg.t0, right = reg.t1;
					if (q.src1 instanceof IntegerConst) {
						board.addText("li " + left + ", " + ((IntegerConst)q.src1).value);
					} else {
						loadByAddress(left, (Name)q.src1);
					}
					
					if (q.src2 instanceof IntegerConst) {
						board.addText("li " + right + ", " + ((IntegerConst)q.src2).value);
					} else {
						loadByAddress(right, (Name)q.src2);
					}
						
					switch (q.op) {
					case EQ : s = "beq " + left + ", " + right; break;
					case NE : s = "bne " + left + ", " + right; break;
					case GT : s = "bgt " + left + ", " + right; break;
					case GE : s = "bge " + left + ", " + right; break;
					case LT : s = "blt " + left + ", " + right; break;
					case LE : s = "ble " + left + ", " + right; break;
					default : error();
					}
					board.addText(s + ", LABEL" + q.label.num);
				} else if (quad instanceof Label) { 
					board.addText("LABEL" + ((Label)quad).num + ":");
				} else if (quad instanceof MemoryRead) {
					MemoryRead q = (MemoryRead)quad;
					loadByAddress(reg.t0, q.src);
					loadByMemory(reg.t0, reg.t0, 0, q.size);
					storeInAddress(reg.t0, q.dest);
				} else if (quad instanceof MemoryWrite) {
					MemoryWrite q = (MemoryWrite)quad;
					loadByAddress(reg.t0, q.src);
					loadByAddress(reg.t1, q.dest);
					storeInMemory(reg.t0, reg.t1, 0, q.size);
				} else if (quad instanceof Return) {
					Param param = ((Return)quad).value;
					if (param == null) {
						board.addText("add $v0, $sp, $zero");
					} else if (param instanceof BasicParam) {
						Address addr = ((BasicParam)param).src;
						if (addr instanceof IntegerConst) {
							board.addText("li $v0, " + ((IntegerConst)addr).value);
						} else if (addr instanceof StringAddressConst) {
							board.addText("la $v0, " + newStringConst(((StringAddressConst)addr).value));
						} else {
							loadByAddress("$v0", addr);
						}
					} else if (param instanceof MemoryParam) {
						Address addr = ((MemoryParam)param).src;
						loadByAddress("$v0", (Name)addr);
					}
					board.addText("lw $ra, 0($sp)");
					board.addText("add $sp, $sp, " + totalSize);
					board.addText("jr $ra");
				} else if (quad instanceof PrintByte) {
					char c = ((PrintByte)quad).c;
					board.addText("li $a0, " + (int)c);
					board.addText("li $v0, 11");
					board.addText("syscall");
				} else if (quad instanceof PrintChar) {
					loadByAddress("$a0", ((PrintChar)quad).name);
					board.addText("li $v0, 11");
					board.addText("syscall");
				} else if (quad instanceof PrintInt) {
					loadByAddress("$a0", ((PrintInt)quad).name);
					board.addText("li $v0, 1");
					board.addText("syscall");
				} else if (quad instanceof PrintIntImmediate) {
					board.addText("li $a0, " + ((PrintIntImmediate)quad).value);
					board.addText("li $v0, 1");
					board.addText("syscall");
				} else if (quad instanceof PrintString) {
					loadByAddress("$a0", ((PrintString)quad).name);
					board.addText("li $v0 4");
					board.addText("syscall");
				} else if (quad instanceof PrintStringImmediate) {
					String str = ((PrintStringImmediate)quad).str + '\0';
					String name = newStringConst(str);
					board.addText("la $a0, " + name);
					board.addText("li $v0 4");
					board.addText("syscall");
				} else if (quad instanceof MallocInt) {
					loadByAddress("$a0", ((MallocInt)quad).name);
					board.addText("li $v0, 9");
					board.addText("syscall");
					storeInAddress("$v0", ((MallocInt)quad).ret);
				} else if (quad instanceof MallocIntImmediate) {
					board.addText("li $a0, " + ((MallocIntImmediate)quad).value);
					board.addText("li $v0, 9");
					board.addText("syscall");
					storeInAddress("$v0", ((MallocIntImmediate)quad).ret);
				} else {
					error();
				}
			}
				
			if (!isStart) {
				board.addText("lw $ra, 0($sp)");
				board.addText("add $v0, $sp, $zero");
				board.addText("add $sp, $sp, " + totalSize);
				board.addText("jr $ra");
			} else {
				board.addText("li $v0, 10");
				board.addText("syscall");
			}
		}
		return board;
	}
}
