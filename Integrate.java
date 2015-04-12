//package Grammar;

import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;

import Grammar.GrammarLexer;
import Grammar.GrammarParser;
import Grammar.GrammarParser.ProgramContext;

public class Integrate {
	public static void main(String[] args) throws Exception {
              // create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(System.in); // create a lexer that feeds off of input CharStream
		GrammarLexer lexer = new GrammarLexer(input); // create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer); // create a parser that feeds off the tokens buffer
		GrammarParser parser = new GrammarParser(tokens);
		ParseTree tree = parser.program(); // begin parsing at init rule
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree }
	}
}