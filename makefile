all:
	mkdir -p bin
	cd src/compiler2015/syntactic && make
	javac src/compiler2015/*/*.java -classpath src/lib/antlr-4.5-complete.jar -d bin
	

clean:
	cd src/compiler2015/syntactic && make clean
	rm -rf bin
