package Compiler2015.ast;

import java.util.List;

import Compiler2015.syntactic.CParser;

public class FunctionCall extends Expr {
    public Symbol body;
    public List<Expr> args;

    public FunctionCall() {
        body = null;
        args = null;
    }

    public FunctionCall(Symbol body, List<Expr> args) {
        this.body = body;
        this.args = args;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[FunctionCall]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(body = " + body.toString() + "):");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(args):");
        for (Expr it : args) {
            it.draw(blank + CParser.SPAN * 2);
        }
    }    
}
