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

public class MidTermX {
	final static boolean DEBUG = true;
	final static String TESTCASE_FOLDER = "/Users/liwenhao/Project/compiler2015/testcases/Phase2/Passed-new";
	static boolean ok;
	
    static String outputFile = "/Users/liwenhao/Project/compiler2015/src/compiler2015/main/semantic.txt";
    
	
	static class MidTermListener extends BaseErrorListener {
		@Override
		public void syntaxError(Recognizer<?, ?> recognizer,
				Object offendingSymbol, int line, int charPositionInLine,
				String msg, RecognitionException e) {
			System.err.println("Parse Error " + line + " " + charPositionInLine
					+ " " + msg);
			e.printStackTrace();
			ok = false;
			if (DEBUG) {
				System.err.println("exit with 1"); 
			} else {
				System.exit(1);
			}
		}
	}
	
	public static void test(File testcase) throws Exception {
		ANTLRFileStream filestream = new ANTLRFileStream(testcase.getAbsolutePath());
		CLexer lexer = new CLexer(filestream);
		CommonTokenStream stream = new CommonTokenStream(lexer);
		CParser parser = new CParser(stream);
		stream.fill();

		parser.removeErrorListeners();
		ok = true;
		parser.addErrorListener(new MidTermListener());
		
		ProgramContext context = parser.program();
		if (!ok) return;
		
		AST ast = context.ret;

		//ast.draw(0);
		//System.out.println();
		
		Semantic semantic = new Semantic(ast);
		if (semantic.hasError()) {
			exit(1);
		} else {
			exit(0);
		}
	}
	
	private static void exit(int i) {
		System.err.println("exit with " + i);
		if (!DEBUG) {
			System.exit(i);
		}
	}

	
	public static void main(String[] args) throws Exception {
		PrintStream ps = new PrintStream(new FileOutputStream(outputFile));
		System.setOut(ps);
		
		if (DEBUG) {
			FilenameFilter filter = new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					int index = name.indexOf('.');
					if (index == -1)
						return false;
					return name.substring(index).equals(".c");
				}
			};
			File[] testcases = new File(TESTCASE_FOLDER).listFiles(filter);
			for (File testcase : testcases) {
				System.out.println(testcase.getName() + " : ");
				System.err.println(testcase.getName() + "   ");
				test(testcase);
			}
		} else {
			test(new File(args[0]));
		}
	}
}
