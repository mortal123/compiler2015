package compiler2015.ir;

public class PrintInt extends Quadruple {
	public Name name;
	public PrintInt(Name _name) {
		name = _name;
	}
	
	public void show() {
		System.out.println("    print_int " + name.getStr());
	}
}
