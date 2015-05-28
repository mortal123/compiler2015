package compiler2015.ir;

public class PrintChar extends Quadruple {
	public Name name;
	public PrintChar(Name _name) {
		name = _name;
	}
	
	public void show() {
		System.out.println("    print_char " + name.getStr());
	}
}
