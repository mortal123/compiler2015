package Compiler2015.ast;

import Compiler2015.syntactic.CParser;

public class ArrayAccess extends Expr {
    public Expr body;
    public Expr subscript;

    public ArrayAccess() {
        body = null;
        subscript = null;
    }

    public ArrayAccess(Expr body, Expr subscript) {
        this.body = body;
        this.subscript = subscript;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[ArrayAccess]:");
        
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
        System.out.println("(subscript):");
        subscript.draw(blank + CParser.SPAN * 2);
    }
}
