package compiler2015.ast;

import java.util.List;

import compiler2015.syntactic.CParser;

public class FunctionDecl extends Decl {
    public Type returnType;
    public Symbol name;
    public List<VarDecl> params;
    public CompoundStmt body;

    public FunctionDecl() {
        returnType = null;
        name = null;
        params = null;
        body = null;
    }

    public FunctionDecl(Type returnType, Symbol name, List<VarDecl> params, CompoundStmt body) {
        this.returnType = returnType;
        this.name = name;
        this.params = params;
        this.body = body;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[FunctionDecl name = " + name.toString() + "]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(returnType):");
        returnType.draw(blank + CParser.SPAN * 2);
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(params):");
        for (VarDecl it : params) {
            it.draw(blank + CParser.SPAN * 2);
        }

        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(body):");
        body.draw(blank + 2 * CParser.SPAN);
    }
}
