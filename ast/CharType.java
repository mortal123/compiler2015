package Compiler2015.ast;

public class CharType extends BasicType {
	void draw(int blank) {
	    for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[Char]");
	}
}
