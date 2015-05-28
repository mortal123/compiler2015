package compiler2015.ir;

public class MallocInt extends Quadruple {
	public Name name;
	public Name ret;
	public MallocInt(Name _name, Name _ret) {
		name = _name;
		ret = _ret;
	}
	
	public void show() {
		System.out.println("    malloc_int " + name.getStr());
	}
}
