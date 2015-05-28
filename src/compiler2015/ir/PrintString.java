package compiler2015.ir;

public class PrintString extends Quadruple {
	public Name name;
	public PrintString(Name _name) {
		name = _name;
	}
	
	public void show() {
		System.out.println("    print_string " + name.getStr());
	}
}
