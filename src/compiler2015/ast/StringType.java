package compiler2015.ast;

import compiler2015.syntactic.CParser;

public class StringType extends Type {
	// baseType = CharType;
	
	int length;
	
	public StringType(int _length) {
		length = _length;
	}
	
    public void draw(int x) {
    	System.out.println("Impossible!!");
    }
}
