package Compiler2015.ast;

import Compiler2015.syntactic.CParser;

public class VarDecl extends Decl {
    public Type type;
    public Symbol name;
    public Initializer init;

    public VarDecl() {
        type = null;
        name = null;
        init = null;
    }

    public VarDecl(Type type, Symbol name, Initializer init) {
        this.type = type;
        this.name = name;
        this.init = init;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[VarDecl name = " + name.toString() + "]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(type):");
        type.draw(blank + CParser.SPAN * 2);
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(init):");
        if (init != null) {
            init.draw(blank + CParser.SPAN * 2);
        }    
    }
}
