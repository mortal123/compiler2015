package Compiler2015.main;

import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;

import Compiler2015.syntactic.CLexer;
import Compiler2015.syntactic.CParser;
import Compiler2015.ast.*;
import Compiler2015.syntactic.CParser.ProgramContext;

public class Integrate {
    static String inputFile = "/Users/liwenhao/Project/Compiler2015/main/sample.c";
    static String outputFile = "result.txt";
    static AST ast = null;

    public static void main(String[] args) throws Exception {
      //  PrintStream ps = new PrintStream(new FileOutputStream(outputFile));
      //  System.setOut(ps);
        travel();
    }

	private static void travel() throws Exception {
//        ANTLRInputStream input = new ANTLRInputStream(System.in);
		ANTLRFileStream input = new ANTLRFileStream(inputFile); 
		CLexer lexer = new CLexer(input); 
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
        tokens.fill();
		CParser parser = new CParser(tokens); 
		ProgramContext context = parser.program(); 
        ast = context.ret;
        ast.draw(0);
	}
}
