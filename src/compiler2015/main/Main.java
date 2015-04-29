package compiler2015.main;

import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;

import compiler2015.semantic.*;
import compiler2015.syntactic.CLexer;
import compiler2015.syntactic.CParser;
import compiler2015.ast.*;
import compiler2015.syntactic.CParser.ProgramContext;
import compiler2015.semantic.*;

public class Main {
	
	static class CListener extends BaseErrorListener {
		@Override
		public void syntaxError(Recognizer<?, ?> recognizer,
				Object offendingSymbol, int line, int charPositionInLine,
				String msg, RecognitionException e) {
			System.err.println("Parse Error " + line + " " + charPositionInLine
					+ " " + msg);
			e.printStackTrace();
			System.err.println("exit with 1");
			System.exit(1);
		}
	}

    static String inputFile = "/Users/liwenhao/Project/compiler2015/src/compiler2015/main/sample.c";
    static String outputFile = "/Users/liwenhao/Project/compiler2015/src/compiler2015/main/result.txt";
    static AST ast = null;

    public static void main(String[] args) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream(outputFile));
        System.setOut(ps);
        try {
        	syntactic();
        } catch (Exception e) {
        	System.out.println("Parsing Error");
        	throw e;
        }
        
        Semantic test = new Semantic(ast);
        if (test.hasError()) {
        	System.out.println("Semantic Error");
        	return ;
        }
        
    }

	private static void syntactic() throws Exception {
//        ANTLRInputStream input = new ANTLRInputStream(System.in);
		ANTLRFileStream input = new ANTLRFileStream(inputFile); 
		CLexer lexer = new CLexer(input); 
		CommonTokenStream tokens = new CommonTokenStream(lexer); 
        tokens.fill();
        
		CParser parser = new CParser(tokens); 
		parser.addErrorListener(new CListener());
		ProgramContext context = parser.program(); 
        ast = context.ret;
        ast.draw(0);
    }
}
