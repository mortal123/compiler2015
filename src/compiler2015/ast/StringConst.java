package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class StringConst extends Expr {
    public String value;

    public StringConst() {
        value = null;
    }

    public StringConst(String value) {
        this.value = value;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[StringConst value = " + value + "]:");
    }
}
