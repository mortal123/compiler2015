package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class UnaryExpr extends Expr {
    public UnaryOp op;
    public Expr expr;

    public UnaryExpr() {
        op = null;
        expr = null;
    }

    public UnaryExpr(UnaryOp op, Expr expr) {
        this.op = op;
        this.expr = expr;
    }
    
    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[UnaryExpr op = " + op.name() + "]:");
        
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
