package Compiler2015.ast;

public class CharConst extends Expr {
    public String value;

    public CharConst() {
    }

    public CharConst(String value) {
        this.value = value;
    }
}
