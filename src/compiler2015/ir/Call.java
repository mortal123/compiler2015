package compiler2015.ir;

public class Call extends Quadruple {
    public Param returnValue;
    public String callee;
    public int numOfParams;

    public Call() {
        returnValue = null;
        callee = null;
        numOfParams = 0;
    }

    public Call(Param returnValue, String callee, int numOfParams) {
        this.returnValue = returnValue;
        this.callee = callee;
        this.numOfParams = numOfParams;
    }
    
    public void show() {
    	if (returnValue == null) {
    		System.out.printf("Param void");
    	} else {
    		returnValue.show();
    	}
    	System.out.println("==== call " + callee + ", " + numOfParams);
    }
}
