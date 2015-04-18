package Compiler2015.ast;

import Compiler2015.syntactic.CParser;

public class Identifier extends Expr {
    public Symbol symbol;

    public Identifier() {
        symbol = null;
    }

    public Identifier(Symbol symbol) {
        this.symbol = symbol;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[Symbol = " + symbol.toString() + "]");
    }
}
