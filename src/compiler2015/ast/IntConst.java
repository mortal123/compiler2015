package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class IntConst extends Expr {
    public int value;

    public IntConst() {
        value = 0;
    }

    public IntConst(int value) {
        this.value = value;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[IntConst value = " + value + "]");
    }
}
