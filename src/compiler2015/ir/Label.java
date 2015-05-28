package compiler2015.ir;

public class Label extends Quadruple {
    private static int labelCount = 0;

    public int num;

    public Label() {
        num = labelCount++;
    }
    
    public void show() {
    	System.out.println("    Label " + num);
    }
    
    public String getStr() {
    	return "Label " + num;
    }
}
