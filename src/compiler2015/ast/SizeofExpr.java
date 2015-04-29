package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class SizeofExpr extends Expr {
    public Type type;

    public SizeofExpr() {
        type = null;
    }

    public SizeofExpr(Type type) {
        this.type = type;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[SizeofExpr]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(type):");
        type.draw(blank + CParser.SPAN * 2);
    }
}
