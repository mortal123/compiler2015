package Compiler2015.ast;

public class StringConst extends Expr {
    public String value;

    public StringConst() {
        value = null;
    }

    public StringConst(String value) {
        this.value = value;
    }
}
