package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class PointerType extends Type {
    public Type baseType;

    public PointerType() {
        baseType = null;
    }

    public PointerType(Type baseType) {
        this.baseType = baseType;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[PointerType]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(baseType):");
        baseType.draw(blank + CParser.SPAN * 2);
    }
}
