package Compiler2015.ast;

import java.util.List;
import java.util.LinkedList;

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
}
