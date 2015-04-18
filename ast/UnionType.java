package Compiler2015.ast;

import Compiler2015.syntactic.CParser;

public class UnionType extends BasicType {
    public Symbol tag;

    public UnionType() {
        tag = null;
    }

    public UnionType(Symbol tag) {
        this.tag = tag;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[UnionType tag = " + tag.toString() + "]:");
    }
}
