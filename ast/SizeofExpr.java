package Compiler2015.ast;

public class SizeofExpr extends Expr {
    public Type type;

    public SizeofExpr() {
        type = null;
    }

    public SizeofExpr(Type type) {
        this.type = type;
    }
}
