package compiler2015.env;

import compiler2015.ast.*;
import compiler2015.table.*;
import java.util.*;

public class Environment {
    public Table idenEnv = null;
    public Table typeEnv = null;
    public int level = 0;
    public HashSet<String> initset;

    public Environment() {
        initTypeEnv();
        initIdenEnv();
        level = 0;
        initset = new HashSet<String>();
    }

    private void initTypeEnv() {
        typeEnv = new Table();
        typeEnv.put(Symbol.get("char"), new CharType(), level);
        typeEnv.put(Symbol.get("int"), new IntType(), level);
        typeEnv.put(Symbol.get("void"), new VoidType(), level);
    }

    private void initIdenEnv() {
    	idenEnv = new Table();
    	idenEnv.put(Symbol.get("printf"), null, level);
    	idenEnv.put(Symbol.get("malloc"), null, level);
    	idenEnv.put(Symbol.get("getchar"), null, level);
    }
    
    public int getLevel() {
    	return level;
    }
    
    public void beginScope() {
    	++level;
    	idenEnv.beginScope();
    	typeEnv.beginScope();
    }
    
    public void endScope() {
    	--level;
    	idenEnv.endScope();
    	typeEnv.endScope();
    }
    
    public void putIden(Symbol name, Object type) {
    	idenEnv.put(name, type, level);
    }
    
    public void putType(Symbol name, Object type) {
    	typeEnv.put(name, type, level);
    }
    
    public Decl getByType(Symbol name) {
    	Object obj = typeEnv.get(name);
    	if (obj == null) {
    		return null;
    	}
    	return (Decl)obj;
    }
    
    public boolean redByType(Symbol name) {
    	if (typeEnv.getLevel(name) == level) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public Decl getByIden(Symbol name) {
    	Object obj = idenEnv.get(name);
    	if (obj == null) {
    		return null;
    	}
    	return (Decl)obj;
    }

    public boolean redByIden(Symbol name) {
    	if (idenEnv.getLevel(name) == level) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
