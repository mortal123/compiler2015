package compiler2015.main;

import java.io.*;
import java.util.*;

import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.tree.*;

import compiler2015.semantic.*;
import compiler2015.syntactic.CLexer;
import compiler2015.syntactic.CParser;
import compiler2015.ast.*;
import compiler2015.generation.Board;
import compiler2015.generation.Generation;
import compiler2015.intermediate.Intermediate;
import compiler2015.ir.IR;
import compiler2015.syntactic.CParser.ProgramContext;
import compiler2015.semantic.*;

public class FinalTerm {
	final static boolean DEBUG = false;
	final static String TESTCASE_FOLDER = "/Users/liwenhao/Project/compiler2015/testcases/Phase2/Passed-new";
	static boolean ok;
	
    static String outputFile = "/Users/liwenhao/Project/compiler2015/src/compiler2015/main/semantic.txt";
    
	
	static class FinalTermListener extends BaseErrorListener {
		@Override
		public void syntaxError(Recognizer<?, ?> recognizer,
				Object offendingSymbol, int line, int charPositionInLine,
				String msg, RecognitionException e) {
			
			ok = false;
			System.exit(1);
		}
	}

	public static void std_test() throws Exception {
		ANTLRInputStream filestream = new ANTLRInputStream(System.in);
		CLexer lexer = new CLexer(filestream);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		CParser parser = new CParser(stream);
//		stream.fill();
		
		lexer.removeErrorListeners();
		parser.removeErrorListeners();
		ok = true;
		
		lexer.addErrorListener(new FinalTermListener());
		parser.addErrorListener(new FinalTermListener());
		
		ProgramContext context = parser.program();
		if (!ok) return;
		
		AST ast = context.ret;

		//ast.draw(0);
		//System.out.println();
		
		Semantic semantic = new Semantic(ast);
		if (semantic.hasError()) {
			exit(1);
		}
		
		IR ir = (new Intermediate()).generateIR(ast);
        //ir.show();
        Board board = (new Generation(ir)).generate();
        board.print();
	}
	
	private static void exit(int i) {
//		System.err.println("exit with " + i);
		if (!DEBUG) {
			System.exit(i);
		}
	}

	
	public static void main(String[] args) throws Exception {
//		PrintStream ps = new PrintStream(new FileOutputStream(outputFile));
//		System.setOut(ps);
		std_test();
	}
}
