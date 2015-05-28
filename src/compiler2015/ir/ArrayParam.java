package compiler2015.ir;

public class ArrayParam extends Param {
    public Name name;
    public Address offset;
    public int size;

    public ArrayParam() {
        name = null;
        offset = null;
        size = 0;
    }

    public ArrayParam(Name name, Address offset, int size) {
        this.name = name;
        this.offset = offset;
        this.size = size;
    }
    
    public void show() {
    	System.out.println("    param " + name.getStr() + "(" + offset.getStr() + "), " + size);
    }
}
