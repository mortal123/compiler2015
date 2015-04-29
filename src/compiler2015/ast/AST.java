package compiler2015.ast;

import compiler2015.syntactic.CParser;
import java.util.List;
import java.util.LinkedList;

public class AST {
    public List<Decl> decls;

    public AST() {
        decls = new LinkedList<Decl>();
    }

    public AST(List<Decl> decls) {
        this.decls = decls;
    }
    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[AST]:");
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(decls):");
        
        for (Decl it : decls) {
        	it.draw(blank + CParser.SPAN * 2);
        }
    }

}
