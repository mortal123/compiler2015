package compiler2015.ir;

public class IfFalseGoto extends Quadruple {
    public Address src1;
    public RelationalOp op;
    public Address src2;
    public Label label;

    public IfFalseGoto() {
        src1 = null;
        op = null;
        src2 = null;
        label = null;
    }

    public IfFalseGoto(Address src1, RelationalOp op, Address src2, Label label) {
        this.src1 = src1;
        this.op = op;
        this.src2 = src2;
        this.label = label;
    }
    
    public String showOp(RelationalOp op) {
    	switch (op) {
    	case EQ : return new String("==");
    	case NE : return new String("!=");
    	case GT : return new String(">");
    	case GE : return new String(">=");
    	case LT : return new String("<");
    	case LE : return new String("<=");
    	default : return new String();
    	}
    }
    
    public void show() {
    	System.out.println("    IfFalse " + src1.getStr() + " " + showOp(op) + " " + src2.getStr() + " goto " + label.getStr());
    }
}
