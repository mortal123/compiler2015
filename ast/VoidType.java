package Compiler2015.ast;

public class VoidType extends BasicType {
	void draw(int blank) {
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[VOID]");
    }
}
