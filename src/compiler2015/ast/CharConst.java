package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class CharConst extends Expr {
    public int value;

    public CharConst() {
    }

    int trans(String s) {
    	if (s.length() >= 4 && s.charAt(1) == '\\') {
    		int ret = 0, ptr = 3;
    		if (s.charAt(2) == '0') {
    			while (s.charAt(ptr) != '\'') {
    				ret = ret * 8 + s.charAt(ptr) - '0';
    				ptr++;
    			}
    			return ret;
    		} else if (s.charAt(3) == 'x') {
    			while (s.charAt(ptr) != '\'') { 
    				ret = ret * 16 + s.charAt(ptr) - '0';
    				ptr++;
    			}
    		}
    	}
    	if (s.length() == 4) {
	    	if (s.charAt(2) == 'a') {
				return (char)7;
			} else if (s.charAt(2) == 'b') {
				return '\b';
			} else if (s.charAt(2) == 't') {
				return '\t';
			} else if (s.charAt(2) == 'n') {
				return '\n';
			} else if (s.charAt(2) == 'f') {
				return '\f';
			} else if (s.charAt(2) == 'r') {
				return '\r';
			} else if (s.charAt(2) == '"') {
				return '\"';
			} else if (s.charAt(2) == '\'') {
				return '\'';
			} else if (s.charAt(2) == 'v') {
				return (char)11;
			} else if (s.charAt(2) == '\\') {
				return '\\';
			} else if (s.charAt(2) == '0') {
				return '\0';
			} else {
				return '\\';
			}
    	}
    	return s.charAt(1);
    }
    
    public CharConst(String value) {
        this.value = trans(value);
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        char cc = (char)value;
        System.out.println("[CharConst: '" + value + "->" + cc + "\']");
    }   
}
