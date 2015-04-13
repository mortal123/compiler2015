//package Compiler2015.syntatic;

import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;

import Compiler2015.syntactic.CLexer;
import Compiler2015.syntactic.CParser;
//import Compiler2015.syntactic.CParser.ProgramContext;

public class Integrate {
	public static void main(String[] args) throws Exception {
              // create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(System.in); // create a lexer that feeds off of input CharStream
		CLexer lexer = new CLexer(input); // create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer); // create a parser that feeds off the tokens buffer
		CParser parser = new CParser(tokens);
		ParseTree tree = parser.program(); // begin parsing at init rule
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree }
	}
}