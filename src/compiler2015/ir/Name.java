package compiler2015.ir;

public class Name extends Address {
    public String name;

    public Name() {
        name = null;
    }

    public Name(String name) {
        this.name = name;
    }
    
    public String getStr() {
    	return name;
    }
}
