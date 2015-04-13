package Compiler2015.ast;

public class SelfDecrement extends Expr {
    public Expr body;

    public SelfDecrement() {
        body = null;
    }

    public SelfDecrement(Expr body) {
        this.body = body;
    }
}
