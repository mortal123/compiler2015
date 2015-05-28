package compiler2015.ir;

import java.util.List;
import java.util.LinkedList;

public class IR {
    public List<Function> fragments;
    
    public IR() {
        fragments = new LinkedList<Function>();
    }

    public IR(List<Function> fragments) {
        this.fragments = fragments;
    }
    
    public void show() {
    	for (int i = 0; i < fragments.size(); i++) {
    		fragments.get(i).show();
    		System.out.println("");
    	}
    }
}
