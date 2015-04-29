package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class ForLoop extends Stmt {
    public Expr init;
    public Expr condition;
    public Expr step;
    public Stmt body;

    public ForLoop() {
        init = null;
        condition = null;
        step = null;
        body = null;
    }

    public ForLoop(Expr init, Expr condition, Expr step, Stmt body) {
        this.init = init;
        this.condition = condition;
        this.step = step;
        this.body = body;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[ForLoop]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(init):");
        init.draw(blank + CParser.SPAN * 2);
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(condition):");
        condition.draw(blank + CParser.SPAN * 2);

        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(step):");
        step.draw(blank + CParser.SPAN * 2);

        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(body):");
        body.draw(blank + CParser.SPAN * 2);

    }
}
