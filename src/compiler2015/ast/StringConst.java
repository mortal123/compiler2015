package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class StringConst extends Expr {
    public String value;

    public StringConst() {
        value = null;
    }
    
    String stringTransform(String s) {
		String ret = "";
		for (int i = 1; i + 1 < s.length(); i++) {
			if (s.charAt(i) == '\\' && i + 2 < s.length()) {
				if (s.charAt(i + 1) == 'a') {
					ret += (char)7;
				} else if (s.charAt(i + 1) == 'b') {
					ret += '\b';
				} else if (s.charAt(i + 1) == 't') {
					ret += '\t';
				} else if (s.charAt(i + 1) == 'n') {
					ret += '\n';
				} else if (s.charAt(i + 1) == 'f') {
					ret += '\f';
				} else if (s.charAt(i + 1) == 'r') {
					ret += '\r';
				} else if (s.charAt(i + 1) == '"') {
					ret += '\"';
				} else if (s.charAt(i + 1) == '\'') {
					ret += '\'';
				} else if (s.charAt(i + 1) == 'v') {
					ret += (char)11;
				} else if (s.charAt(i + 1) == '\\') {
					ret += '\\';
				} else if (s.charAt(i + 1) == '0') {
					ret += '\0';
				} else {
					ret += '\\';
					i--;
				}
				i++;
			} else {
				ret += s.charAt(i);
			}
		}
		return ret;
	}
	

    public StringConst(String _value) {
        value = stringTransform(_value);
    }

    public void draw(int blank) {
        for(int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[StringConst value = \"" + value + "\"]:");
    }
}
