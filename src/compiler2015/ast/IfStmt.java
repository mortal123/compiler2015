package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class IfStmt extends Stmt {
    public Expr condition;
    public Stmt consequent;
    public Stmt alternative;

    public IfStmt() {
        condition = null;
        consequent = null;
        alternative = null;
    }

    public IfStmt(Expr condition, Stmt consequent, Stmt alternative) {
        this.condition = condition;
        this.consequent = consequent;
        this.alternative = alternative;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[IfStmt]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(conditon):");
        condition.draw(blank + CParser.SPAN * 2);
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(consequent):");
        consequent.draw(blank + CParser.SPAN * 2);
    
        if (alternative == null) {
            return ;
        }

        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(alternative):");
        alternative.draw(blank + CParser.SPAN * 2);
    }
}
