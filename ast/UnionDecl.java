package Compiler2015.ast;

import java.util.List;
import Compiler2015.syntactic.CParser;

public class UnionDecl extends Decl {
    public Symbol tag;
    public List<VarDecl> fields;

    public UnionDecl() {
        tag = null;
        fields = null;
    }

    public UnionDecl(Symbol tag, List<VarDecl> fields) {
        this.tag = tag;
        this.fields = fields;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[UnionDecl tag = " + tag.toString() + "]:");
        
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
