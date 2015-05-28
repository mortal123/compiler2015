package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class ArrayType extends Type {
    public Type baseType;
    public Expr arraySize;
    public int size, sizeOf;

    public ArrayType() {
        baseType = null;
        arraySize = null;
        size = -1;
        sizeOf = -1;
    }

    public ArrayType(Type baseType, Expr arraySize) {
        this.baseType = baseType;
        this.arraySize = arraySize;
        size = -1;
        sizeOf = -1;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[ArrayType]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(baseType):");
        baseType.draw(blank + CParser.SPAN * 2);
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(arraySize):");
        arraySize.draw(blank + CParser.SPAN * 2);
    }

}
