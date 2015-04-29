package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class BinaryExpr extends Expr {
    public Expr left;
    public BinaryOp op;
    public Expr right;

    public BinaryExpr() {
        left = null;
        op = null;
        right = null;
    }

    public BinaryExpr(Expr left, BinaryOp op, Expr right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[Expr op = " + op.name() + "]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(left):");
        left.draw(blank + CParser.SPAN * 2);
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(right):");
        right.draw(blank + CParser.SPAN * 2);
    }
}
