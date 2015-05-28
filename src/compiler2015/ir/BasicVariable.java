package compiler2015.ir;

public class BasicVariable extends Variable {
    public BasicVariable() {
        name = null;
        size = 0;
    }

    public BasicVariable(Name name, int size) {
        this.name = name;
        this.size = size;
    }
}
