#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <vector>
#include <string>
#include <iostream>
using namespace std;

string toLower(string s) {
	string res = "";
	for(int i = 0; i < (int)s.length(); i++) {
		if (s[i] == '_') {
			res += ' ';
		} else {
			res += s[i] - 'A' + 'a';
		}
	}
	return res;
}

int main() {
	string str;
	while (cin >> str) {
		if (str[0] == '%') {
			continue;
		}
		cout << str << " : '" << toLower(str) << "' ;" << endl;
		cout << endl;
	}
	return 0;
}