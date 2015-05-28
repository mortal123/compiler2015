package compiler2015.register;

import compiler2015.ir.*;
import compiler2015.generation.*;

public class Naive {
	// only t0 t1
	private final int count = 5;
	private boolean[] occupied = new boolean[count];
	private String[] names = new String[count];
	public String t0 = "$a0", t1 = "$v1", t2 = "$t7", t3 = "$v0";
	
	public Naive() {
		for (int i = 0; i < count; i++) {
			occupied[i] = false;
			names[i] = "$t" + i;
		}
	}
	
	
}
