package compiler2015.ir;

public class PrintIntImmediate extends Quadruple {
	public int value;
	public PrintIntImmediate(int _value) {
		value = _value;
	}
	
	public void show() {
		System.out.println("    print_int_imdediate " + value);
	}
}
