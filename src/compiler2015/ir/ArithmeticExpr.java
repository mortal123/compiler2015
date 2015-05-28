package compiler2015.ir;



public class ArithmeticExpr extends Quadruple {
    public ArithmeticOp op;
    public Address dest;
    public Address src1;
    public Address src2;

    public ArithmeticExpr() {
        op = null;
        dest = null;
        src1 = null;
        src2 = null;
    }

    public ArithmeticExpr(Address dest, Address src1, ArithmeticOp op, Address src2) {
        this.dest = dest;
        this.src1 = src1;
        this.op = op;
        this.src2 = src2;
    }

    public ArithmeticExpr(Address dest, ArithmeticOp op, Address src1) {
        this.dest = dest;
        this.op = op;
        this.src1 = src1;
        this.src2 = null;
    }
    
    public String showOp(ArithmeticOp op) {
    	switch (op) {
    	case ADD : return new String("+");
    	case SUB : return new String("-");
    	case MUL : return new String("*");
    	case DIV : return new String("/");
    	case MOD : return new String("%");
    	case SHL : return new String("<<");
    	case SHR : return new String(">>");
    	case AND : return new String("&");
    	case OR : return new String("|");
    	case XOR : return new String("^");
    	case MINUS : return new String("-");
    	case TILDE : return new String("~");
    	default : return new String();
    	}
    }
    
    public void show() {
    	System.out.print("    " + dest.getStr() +  " = ");
    	if (src2 == null) {
    		System.out.println(showOp(op) + src1.getStr());
    	} else {
	    	System.out.println(src1.getStr() + " " + showOp(op) + " " + src2.getStr());
    	}
    }
}
