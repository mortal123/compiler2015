package compiler2015.generation;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.io.*;

public class Board {
	List<String> data = new LinkedList<String>();
	List<String> text = new LinkedList<String>();
	static String outputFile = "/Users/liwenhao/Project/compiler2015/src/compiler2015/main/code.s";
    
	public Board() {
		data.add("global_buffer: .space 100");
	}
	
	public void addData(String s) {
		data.add(s);
	}
	
	public void addText(String s) {
		text.add(s);
	}
	
	public void print() throws Exception {
	    PrintStream ps = new PrintStream(new FileOutputStream(outputFile));
        System.setOut(ps);
    
		System.out.println("");
		System.out.println("");
		System.out.println("");
		//System.out.println("--------------------Code Generation------------------------------");
		
		System.out.println("\t\t.data");
		for (String s : data) {
			System.out.println(s);
		}
		
		System.out.println("");
		System.out.println("\t\t.text");
		for (String s : text) {
			System.out.println(s);
		}
		
		// getchar
		System.out.println("\n___getchar:");
		System.out.println("li $v0, 12");
		System.out.println("syscall");
		System.out.println("jr $ra");
		
		System.out.println("___printf:");
		System.out.println("la $gp, global_buffer");
		System.out.println("sw $a0, ($gp)");
		System.out.println("sw $t0, 4($gp)");
		System.out.println("sw $t1, 8($gp)");
		System.out.println("sw $t2, 12($gp)");
		System.out.println("sw $t3, 16($gp)");
		System.out.println("sw $a2, 20($gp)");
		System.out.println("");
		System.out.println("__printf:");
		System.out.println("add $t2, $sp, -8");
		System.out.println("lw $t1, -4($sp)");
		System.out.println("add $t1, $t1, -1");
		System.out.println("__printf_loop:");
		System.out.println("add $t1, $t1, 1");
		System.out.println("lb $a2, ($t1)");
		System.out.println("beq $a2, 0, __printf_end");
		System.out.println("beq $a2, 37, __printf_format");//      # %     # %04d, %d, %c, %s, %04d <-> only positve integer   %: 37   \: 92  \n: 10  \t: 9 ");
		System.out.println("beq $a2, 92, __printf_trans");//       # \     # \n, \t");
		System.out.println("__printf_normal:");
		System.out.println("li $v0, 11");
		System.out.println("lb $a0, ($t1)");
		System.out.println("syscall");
		System.out.println("j __printf_loop");
		System.out.println("__printf_format:");
		System.out.println("lb $t0, 1($t1)");
		System.out.println("beq $t0, 'd', __printf_format_d");
		System.out.println("beq $t0, 'c', __printf_format_c");
		System.out.println("beq $t0, 's', __printf_format_s");
		System.out.println("beq $t0, '.', __printf_format_fuck       # %.9d");
		System.out.println("beq $t0, '0', __printf_format_fuck       # %.9d");
		System.out.println("beq $t0, 37, __printf_format_percent     # %");
		System.out.println("j __printf_normal");
		System.out.println("__printf_format_d:");
		System.out.println("li $v0, 1");
		System.out.println("lw $a0, ($t2)");
		System.out.println("syscall");
		System.out.println("j __printf_format_cont");
		System.out.println("");
		System.out.println("__printf_format_c:");
		System.out.println("li $v0, 11");
		System.out.println("lw $a0, ($t2)");
		System.out.println("syscall");
		System.out.println("j __printf_format_cont");
		System.out.println("__printf_format_s:");
		System.out.println("li $v0, 4");
		System.out.println("lw $a0, ($t2)");
		System.out.println("syscall");
		System.out.println("j __printf_format_cont");
		System.out.println("__printf_format_fuck:");
		System.out.println("add $t1, $t1, 2");
		System.out.println("lw $a2, ($t2)");
		System.out.println("");
		System.out.println("lb $t3, ($t1)");
		System.out.println("add $t3, -48   # $t3 .x");
		System.out.println("");
		System.out.println("li $t4, 0                      # length of $a2");
		System.out.println("");
		System.out.println("__calc_length:");
		System.out.println("beq $a2, 0, __printf_format_fuck_leading");
		System.out.println("add $t4, $t4, 1");
		System.out.println("div $a2, $a2, 10");
		System.out.println("j __calc_length");
		System.out.println("");
		System.out.println("__printf_format_fuck_leading:");
		System.out.println("bge $t4, $t3, __printf_format_fuck_body ");
		System.out.println("li $v0, 11");
		System.out.println("li $a0, '0'");
		System.out.println("syscall");
		System.out.println("add $t3, $t3, -1");
		System.out.println("j __printf_format_fuck_leading");
		System.out.println("");
		System.out.println("__printf_format_fuck_body:");
		System.out.println("li $v0, 1");
		System.out.println("lw $a0, ($t2)");
		System.out.println("syscall");
		System.out.println("");
		System.out.println("__printf_format_cont:");
		System.out.println("add $t2, $t2, -4");
		System.out.println("add $t1, $t1, 1");
		System.out.println("j __printf_loop");
		System.out.println("");
		System.out.println("__printf_trans:");
		System.out.println("li $v0, 11");
		System.out.println("add $t1, $t1, 1");
		System.out.println("lb $a0, ($t1)");
		System.out.println("beq $a0, 'n', __next_line");
		System.out.println("li $a0, 9                            # \t");
		System.out.println("j __ending");
		System.out.println("__next_line:");
		System.out.println("li $a0, 10							 # \n");
		System.out.println("__ending:");
		System.out.println("syscall");
		System.out.println("j __printf_loop");
		System.out.println("");
		System.out.println("__printf_format_percent:");
		System.out.println("li $v0, 11");
		System.out.println("add $t1, $t1, 1");
		System.out.println("li $a0, 37						     # %");
		System.out.println("syscall");
		System.out.println("j __printf_loop");
		System.out.println("");
		System.out.println("__printf_end:");
		System.out.println("");
		System.out.println("");
		System.out.println("lw $a0, ($gp)");
		System.out.println("lw $t0, 4($gp)");
		System.out.println("lw $t1, 8($gp)");
		System.out.println("lw $t2, 12($gp)");
		System.out.println("lw $t3, 16($gp)");
		System.out.println("lw $a2, 20($gp)");
		System.out.println("");
		System.out.println("jr $ra");
	}
}
