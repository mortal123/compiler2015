package compiler2015.ir;

public class Goto extends Quadruple {
    public Label label;

    public Goto() {
        label = null;
    }

    public Goto(Label label) {
        this.label = label;
    }
    
    public void show() {
    	System.out.println("    goto " + label.getStr());
    }
}
