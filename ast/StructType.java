package Compiler2015.ast;

public class StructType extends BasicType {
    public Symbol tag;

    public StructType() {
    }

    public StructType(Symbol tag) {
        this.tag = tag;
    }
}
