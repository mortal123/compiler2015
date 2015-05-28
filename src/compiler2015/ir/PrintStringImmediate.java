package compiler2015.ir;

public class PrintStringImmediate extends Quadruple {
	public String str;
	public PrintStringImmediate(String _str) {
		str = _str;
	}
	
	public void show() { 
		System.out.println("    print_string_immediate " + str);
	}
	
}
