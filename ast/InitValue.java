package Compiler2015.ast;

import Compiler2015.syntactic.CParser;

public class InitValue extends Initializer {
    public Expr expr;

    public InitValue() {
        expr = null;
    }

    public InitValue(Expr expr) {
        this.expr = expr;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[InitValue]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(expr):");
        expr.draw(blank + CParser.SPAN * 2);
    }
}
