package Compiler2015.ast;

import Compiler2015.syntactic.CParser;

public class WhileLoop extends Stmt {
    public Expr condition;
    public Stmt body;

    public WhileLoop() {
        condition = null;
        body = null;
    }

    public WhileLoop(Expr condition, Stmt body) {
        this.condition = condition;
        this.body = body;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[WhileLoop]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(condition):");
        condition.draw(blank + CParser.SPAN * 2);
        
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
