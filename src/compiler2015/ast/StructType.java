package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class StructType extends BasicType {
    public Symbol tag;
    public int sizeOf;
    
    public StructType() {
    	sizeOf = -1;
    }
    
    public StructType(Symbol tag) {
        this.tag = tag;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[StructType tag = " + tag.toString() + "]:");
    }
}
