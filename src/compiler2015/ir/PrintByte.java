package compiler2015.ir;

public class PrintByte extends Quadruple {
	public char c;
	public PrintByte(char _c) {
		c = _c;
	}
	
	public PrintByte(int _c) {
		c = (char)_c;
	}
	
	public void show() {
		System.out.println("    print_byte " + c);
	}
}
