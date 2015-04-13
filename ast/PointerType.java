package Compiler2015.ast;

public class PointerType extends Type {
    public Type baseType;

    public PointerType() {
        baseType = null;
    }

    public PointerType(Type baseType) {
        this.baseType = baseType;
    }
}
