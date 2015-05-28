package compiler2015.ir;

public class BasicParam extends Param {
    public Address src;

    public BasicParam() {
        src = null;
    }

    public BasicParam(Address src) {
        this.src = src;
    }
    
    public void show() {
    	System.out.println("    param " + src.getStr());
    }
}
