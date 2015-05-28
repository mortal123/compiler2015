package compiler2015.ir;

import java.util.List;
import java.util.LinkedList;

public class Function {
    public String name;
    public int size;
    public List<Variable> args;
    public List<Variable> vars;
    public List<Quadruple> body;

    public Function() {
        name = null; 
        size = 0;
        args = new LinkedList<Variable>();
        vars = new LinkedList<Variable>();
        body = new LinkedList<Quadruple>();
    }

    public Function(String name, int size, List<Variable> args, 
                    List<Variable> vars, List<Quadruple> body) {
        this.name = name;
        this.size = size;
        this.args = args;
        this.vars = vars;
        this.body = body;
    }
    
    public Function(String name, int size) {
		this.name = name;
		this.size = size;
        args = new LinkedList<Variable>();
        vars = new LinkedList<Variable>();
        body = new LinkedList<Quadruple>();
	}
    
    public void show() {
    	System.out.println("function " + name + ":       " + size);
    	System.out.println("	args:");
    	for (int i = 0; i < args.size(); i++) {
    		System.out.println("	" + args.get(i).name.name + ": " + args.get(i).size);
    	}
    	System.out.println("	var:");
    	for (int i = 0; i < vars.size(); i++) {
    		System.out.println("	" + vars.get(i).name.name + ": " + vars.get(i).size);	
    	}
    	System.out.println("	body:");
    	for (int i = 0; i < body.size(); i++) {
    		body.get(i).show();
    	}
    	
    }
} 
