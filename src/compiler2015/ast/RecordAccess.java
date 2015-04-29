package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class RecordAccess extends Expr {
    public Expr body;
    public Symbol attribute;

    public RecordAccess() {
        body = null;
        attribute = null;
    }

    public RecordAccess(Expr body, Symbol attribute) {
        this.body = body;
        this.attribute = attribute;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[RecordAccess]:");
        
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
