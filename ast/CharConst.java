package Compiler2015.ast;

import Compiler2015.syntactic.CParser;

public class CharConst extends Expr {
    public String value;

    public CharConst() {
    }

    public CharConst(String value) {
        this.value = value;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[CharConst: " + value + "]");
    }   
}
