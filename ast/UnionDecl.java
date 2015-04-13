package Compiler2015.ast;

import java.util.List;

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
}
