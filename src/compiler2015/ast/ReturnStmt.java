package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class ReturnStmt extends Stmt {
    public Expr expr;

    public ReturnStmt() {
        expr = null;
    }

    public ReturnStmt(Expr expr) {
        this.expr = expr;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[ReturnStmt]:");
        
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
