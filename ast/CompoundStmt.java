package Compiler2015.ast;

import java.util.List;

import Compiler2015.syntactic.CParser;

public class CompoundStmt extends Stmt {
    public List<Decl> decls;
    public List<Stmt> stats;

    public CompoundStmt() {
        decls = null;
        stats = null;
    }

    public CompoundStmt(List<Decl> decls, List<Stmt> stats) {
        this.decls = decls;
        this.stats = stats;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[CompoundStmt]:");
        
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
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(stats):");
        for (Stmt it : stats) {
            it.draw(blank + CParser.SPAN * 2);
        }
    }
}
