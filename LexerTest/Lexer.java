import java.io.*;
import java.util.*;

class Token {
	String type, name;
	int value;
	Token(String _type, String _name, int _value) {
		type = new String(_type);
		name = new String(_name);
		value = _value;
	}
};

public class Lexer {
	Scanner input;
	String buffer;
	int ptr;
	boolean lineBegin;

	void Error() throws Exception {
		System.out.print("Wow");
		throw new Exception();
	}

	void goNextLine() {
		while (!isNewLine(buffer.charAt(ptr))) {
			ptr++;
		}
	}

	boolean isDigit(char x) {
		return '0' <= x && x <= '9';
	}

	boolean isHex(char x) {
		return '0' <= x && x <= '9' || 'a' <= x && x <= 'f' || 'A' <= x && x <= 'F';
	}

	boolean isOct(char x) {
		return '0' <= x && x <= '7';
	}

	boolean isNewLine(char x) {
		return x == '\n' || x == '\r';
	}

	boolean isLetter(char x) {
		return 'a' <= x && x <= 'z' || 'A' <= x && x <= 'z' || x == '_' || x == '$';
	}

	char nextChar() {
		if (buffer.charAt(ptr) == '\\') {
			ptr++;
			if (buffer.charAt(ptr) == '\\') {
				return '\\';
			} else {
				char t = buffer.charAt(ptr);
				if (t == 'n') {
					return '\n';
				} else if (t == 't') {
					return '\t';
				} else if (t == 'r') {
					return '\r';
				} else if (t == 'b') {
					return '\b';
				} else if (t == 'x') {
					
				} else if (false) {
					//oct
				} else {
					return t;
				}
			}
		} else {
			return buffer.charAt(ptr);
		}
	}

	

	Token nextToken() throws Exception {
		lineBegin = false;
		while (ptr < buffer.length()) {
			if (buffer.charAt(ptr) == ' ' || buffer.charAt(ptr) == '\t') {

			} else if (isNewLine(buffer.charAt(ptr))) {
				lineBegin = true;				
			} else if (buffer.charAt(ptr) == '#') {
				if (lineBegin == false) {
					Error();
				} else {
					goNextLine();
				}
			} else if (buffer.charAt(ptr) == '/' && buffer.charAt(ptr + 1) == '/') {
				goNextLine();
			} else if (buffer.charAt(ptr) == '/' && buffer.charAt(ptr + 1) == '*') {
				ptr += 3;
				while (!(buffer.charAt(ptr - 1) == '*' && buffer.charAt(ptr) == '/')) {
					ptr++;
				}
			} else {
				break;
			}
			ptr++;
		}
		if (ptr == buffer.length()) {
			return new Token("NULL", "", 0);
		}
		// abc
		if (isLetter(buffer.charAt(ptr))) {
			String ret = new String();
			while (isLetter(buffer.charAt(ptr)) || isDigit(buffer.charAt(ptr))) {
				ret += buffer.charAt(ptr);
				ptr++;
			}
			
			if (isKey(ret)) {
				return Token(ret, "", 0);
			} else {
				return Token("Identifier", ret, 0);
			}
		} else if (isDigit(buffer.charAt(ptr))) {
			// 8
			int base = 10, value = 0;
			if (buffer.charAt(ptr) == '0') {
				if (buffer.charAt(ptr + 1) == 'x' || buffer.charAt(ptr + 1) == 'X') {
					base = 16;
					ptr += 2;
				} else {
					base = 8;
					ptr++;
				}
			}
			while (isHex(buffer.charAt(ptr))) {
				if (isOct(buffer.charAt(ptr))) {
					
				} else if (base == 8) {
					Error();
				} else if (isDigit(buffer.charAt(ptr))) {

				} else if (base == 10) {
					Error();
				} else if (false) {
				}
				if (isDigit(buffer.charAt(ptr))) {
					value = value * base + buffer.charAt(ptr) - '0';
				} else {
					value = value * base + toLower(buffer.charAt(ptr)) - 'a' + 10;
				}
				ptr++;
			}
			if (isLetter(buffer.charAt(ptr))) {
				Error();
			}
			return new Token("ConstInt", "", value);
		} else if (buffer.charAt(ptr) == '\'') {
			ptr++;
			if (buffer.charAt(ptr) == '\'') {
				Error();
			}
			char x = nextChar();
			if (buffer.charAt(ptr) != '\'') {
				Error();
			} else {
				ptr++;
			}
			return new Token("ConstChar", "", x);
		} else if (buffer.charAt(ptr) == '\"') {
			ptr++;
			String ret = new String();
			while (buffer.charAt(ptr) != '\"') {
				ret += buffer.charAt(ptr);
				if (isNewLine(buffer.charAt(ptr)) || buffer.charAt(ptr) == '"') {
					Error();
				}
				ptr++;
			}
			ptr++;
			return new Token("ConstString", ret, 0);
		} else {
			for (int i = optList.length() - 1; i >= 0; i--) {
				boolean match = true;
				for (int j = 0; j < optList[i].length(); j++) {
					if (optList[i][j] != buffer.charAt(ptr + j)) {
						match = false;
						break;
					}
				}
				if (match == true) {
					ptr += optList[i].length();
					return new Token("Operator", optList[i], 0);
				}
			}
			Error();
		}
	} 


	void run() {
		ptr = 0;
		input = new Scanner(System.in);
		buffer = new String();
		while (input.hasNext()) {
			buffer += "\n";
			buffer += input.nextLine();
		}
		buffer += "\0\0\0\0\0\0";
		while (true) {
			Token token = nextToken();
			if (token.type == "NULL") {
				break;
			}
			System.out.print("type = " + token.type + " name = " + token.name + " value = " + token.value);
		}
	}

	public static void main(String args[]) {
		new Lexer().run();
	}
}
