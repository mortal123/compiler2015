#include<string.h>
#include<stdio.h>
char st[2222], a[2222], b[2222];
int next[2222];
int _strlen(char * st) {
	int res = 0;
	while(st[res]) {
		res++;
	}
	return res;
}
int calc() {
	int len, lena, lenb, i, p, stamp, j;
	len = _strlen(st);
	next[0] = -1;
	lena = _strlen(a);
	lenb = _strlen(b);
	for(i = 1; i < lena; i++) {
		next[i] = next[i - 1];
		while(next[i] != -1 && a[next[i] + 1] != a[i]) {
			next[i] = next[next[i]];
		}
		next[i] += a[next[i] + 1] == a[i];
	}
	p = 0;
	stamp = 0;
	for(i = 0; i < len; i++) {
		if(stamp == 0) {
			while(p != 0 && a[p] != st[i]) {
				p = next[p - 1] + 1;
			}
			p += a[p] == st[i];
			if(p == lena) {
				next[0] = -1;
				for(j = 1; j < lenb; j++) {
					next[j] = next[j - 1];
					while(next[j] != -1 && b[next[j] + 1] != b[j]) {
						next[j] = next[next[j]];
					}
					next[j] += b[next[j] + 1] == b[j];
				}
				p = 0;
				stamp = 1;
			}
		}else {
			while(p != 0 && b[p] != st[i]) {
				p = next[p - 1] + 1;
			}
			p += b[p] == st[i];
			if(p == lenb) {
				return 1;
			}
		}
	}
	return 0;
}
void getString(char * st) {
	int len = 0, c;
	for(;;) {
		c = getchar();
		if(c >= 'a' && c <= 'z') {
			st[len++] = c;
		}else {
			st[len] = 0;
			break;
		}
	}
}
int main() {
	int i, len, flag1, flag2, lena, lenb;
	getString(st);
	getString(a);
	getString(b);
	len = _strlen(st);
	lena = _strlen(a);
	lenb = _strlen(b);
	flag1 = calc();
	for(i = 0; i < len / 2; i++) {
		int t = st[i];
		st[i] = st[len - i - 1];
		st[len - i - 1] = t;
	}
	flag2 = calc();
	if(flag1 && flag2) {
		printf("both\n");
	}else if(flag1) {
		printf("forward\n");
	}else if(flag2) {
		printf("backward\n");
	}else {
		printf("fantasy\n");
	}
}
