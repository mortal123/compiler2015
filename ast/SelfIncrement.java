package Compiler2015.ast;

public class SelfIncrement extends Expr {
    public Expr body;

    public SelfIncrement() {
        body = null;
    }

    public SelfIncrement(Expr body) {
        this.body = body;
    }
}
