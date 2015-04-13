package Compiler2015.ast;

public class IntConst extends Expr {
    public int value;

    public IntConst() {
        value = 0;
    }

    public IntConst(int value) {
        this.value = value;
    }
}
