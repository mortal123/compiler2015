package Compiler2015.ast;

public class InitValue extends Initializer {
    public Expr expr;

    public InitValue() {
        expr = null;
    }

    public InitValue(Expr expr) {
        this.expr = expr;
    }
}
