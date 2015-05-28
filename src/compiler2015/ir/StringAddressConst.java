package compiler2015.ir;

public class StringAddressConst extends Const {
	public String value;

    public StringAddressConst() {
        value = null;
    }

    public StringAddressConst(String value) {
        this.value = value;
    }
    
    public String getStr() {
    	return value;
    }
}
