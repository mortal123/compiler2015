package Compiler2015.ast;

import java.util.List;
import java.util.LinkedList;
import Compiler2015.syntactic.CParser;

public class StructDecl extends Decl {
    public Symbol tag;
    public List<VarDecl> fields;

    public StructDecl() {
        tag = null;
        fields = null;
    }

    public StructDecl(Symbol tag, List<VarDecl> fields) {
        this.tag = tag;
        this.fields = fields;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[StructDecl tag = " + tag.toString() + "]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(fields):");
        for (VarDecl it : fields) {
            it.draw(blank + CParser.SPAN * 2);
        }
    }
}
