package compiler2015.env;

import compiler2015.ast.*;
import compiler2015.ir.*;
import compiler2015.table.*;
import java.util.*;

public class EnvironmentIR {
    public Table idenEnv = null;
    public Table typeEnv = null;
    public Table addrEnv = null;
    public Table funcLabelEnv = null;
    public int level = 0;

    public EnvironmentIR() {
        initTypeEnv();
        initIdenEnv();
        initAddrEnv();
        level = 0;
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
    
    private void initAddrEnv() {
    	addrEnv = new Table();
    }
    
    public int getLevel() {
    	return level;
    }
    
    public void beginScope() {
    	++level;
    	idenEnv.beginScope();
    	typeEnv.beginScope();
    	addrEnv.beginScope();
    }
    
    public void endScope() {
    	--level;
    	idenEnv.endScope();
    	typeEnv.endScope();
    	addrEnv.endScope();
    }
    
    public void putIden(Symbol name, Object type) {
    	idenEnv.put(name, type, level);
    }
    
    public void putType(Symbol name, Object type) {
    	typeEnv.put(name, type, level);
    }
    
    public void putAddr(Symbol name, Object address) {
    	addrEnv.put(name, address, level);
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
    
    public Address getByAddr(Symbol name) {
    	Object obj = addrEnv.get(name);
    	if (obj == null) {
    		return null;
    	} else {
    		return (Address) obj;
    	}
    }
}
