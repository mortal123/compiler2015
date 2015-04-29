package compiler2015.ast;

import java.util.List;
import java.util.LinkedList;
import compiler2015.syntactic.CParser;

public class InitList extends Initializer {
    public List<Initializer> inits;

    public InitList() {
        inits = null;
    }

    public InitList(List<Initializer> inits) {
        this.inits = inits;
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[InitList]:");
        
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        for (int i = 2; i <= CParser.SPAN; i++) {
            System.out.print("-");
        }
        System.out.println("(inits):");
        for (Initializer it : inits) {
        	it.draw(blank + CParser.SPAN * 2);
    	}
    }
}
