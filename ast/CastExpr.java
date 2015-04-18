package Compiler2015.ast;

import Compiler2015.syntactic.CParser;

public class CastExpr extends Expr {
    public Type cast;
    public Expr expr;

    public CastExpr() {
        cast = null;
        expr = null;
    }

    public CastExpr(Type cast, Expr expr) {
        this.cast = cast;
        this.expr = expr;
    }
    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[CastExpr]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(cast):");
        cast.draw(blank + CParser.SPAN * 2);
        
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
