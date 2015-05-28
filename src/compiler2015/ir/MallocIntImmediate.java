package compiler2015.ir;

public class MallocIntImmediate extends Quadruple {
	public int value;
	public Name ret;
	public MallocIntImmediate(int _value, Name _name) {
		value = _value;
		ret = _name;
	}
	
	public void show() {
		System.out.println("    malloc_int_immediate " + value);
	}
}