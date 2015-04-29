package compiler2015.ast;

public class IntType extends BasicType {
	void draw(int blank) {
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("[Int]");
    }
}
