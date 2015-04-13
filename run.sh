#!bin/sh

export CLASSPATH=".:/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH"
java -jar /usr/local/lib/antlr-4.5-complete.jar
java org.antlr.v4.Tool
alias antlr4='java -jar /usr/local/lib/antlr-4.5-complete.jar'
alias grun='java org.antlr.v4.runtime.misc.TestRig'
