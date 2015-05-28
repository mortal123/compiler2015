package compiler2015.ir;

public class AddressOf extends Quadruple {
    public Address dest;
    public Name src;

    public AddressOf() {
        dest = null;
        src = null;
    }

    public AddressOf(Address dest, Name src) {
        this.dest = dest;
        this.src = src;
    }
    public void show() {
    	System.out.println("    " + dest.getStr() + " = &" + src.getStr());
    }
}
