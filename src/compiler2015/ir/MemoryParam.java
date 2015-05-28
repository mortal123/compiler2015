package compiler2015.ir;

public class MemoryParam extends Param {
    public Address src;
    public int size;

    public MemoryParam() {
        src = null;
        size = 0;
    }

    public MemoryParam(Address src, int size) {
        this.src = src;
        this.size = size;
    }
    
    public void show() {
    	System.out.println("    param " + src.getStr() + ", " + size);
    }
}
