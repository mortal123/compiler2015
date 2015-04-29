package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class PointerAccess extends Expr {
    public Expr body;
    public Symbol attribute;

    public PointerAccess() {
        body = null;
        attribute = null;
    }

    public PointerAccess(Expr body, Symbol attribute) {
        this.body = body;
        this.attribute = attribute;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[PointerAccess]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(body):");
        body.draw(blank + CParser.SPAN * 2);
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(attribute = " + attribute.toString() + "):");
    }
}
