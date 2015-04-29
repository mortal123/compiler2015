package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class SelfDecrement extends Expr {
    public Expr body;

    public SelfDecrement() {
        body = null;
    }

    public SelfDecrement(Expr body) {
        this.body = body;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[SelfDecrement]:");
        
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
