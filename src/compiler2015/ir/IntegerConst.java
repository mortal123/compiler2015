package compiler2015.ir;

public class IntegerConst extends Const {
    public int value;

    public IntegerConst() {
    }

    public IntegerConst(int value) {
        this.value = value;
    }
    
    public String getStr() {
    	return String.valueOf(value);
    }
}
