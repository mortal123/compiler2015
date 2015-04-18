package Compiler2015.ast;

import Compiler2015.syntactic.CParser;

public class SelfIncrement extends Expr {
    public Expr body;

    public SelfIncrement() {
        body = null;
    }

    public SelfIncrement(Expr body) {
        this.body = body;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[SelfIncrement]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(body):");
        body.draw(blank + CParser.SPAN * 2);
        
    }
}
