package compiler2015.ir;

public class ArrayVariable extends Variable {
    public ArrayVariable() {
        name = null;
        size = 0;
    }

    public ArrayVariable(Name name, int size) {
        this.name = name;
        this.size = size;
    }
}
