package compiler2015.ir;

public class MemoryWrite extends Quadruple {
    public Address dest;
    public Address src;
    public int size;

    public MemoryWrite() {
        dest = null;
        src = null;
        size = 0;
    }

    public MemoryWrite(Address dest, Address src, int size) {
        this.dest = dest;
        this.src = src;
        this.size = size;
    }
    
    public void show() {
    	System.out.println("    *" + dest.getStr() + " = " + src.getStr() + ", " + size);
    }
}
