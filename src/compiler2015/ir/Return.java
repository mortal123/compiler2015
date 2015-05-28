package compiler2015.ir;

public class Return extends Quadruple {
    public Param value;

    public Return() {
        value = null;
    }

    public Return(Param value) {
        this.value = value;
    }
    
    public void show() {
    	System.out.print("    return ");
    	if (value == null) {
    		System.out.println("void");
    	} else {
    		value.show();
    	}
    }
}
