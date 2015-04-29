package compiler2015.table;

import compiler2015.ast.Symbol;
import java.util.*;

class Binder {
    Object value;
    Binder tail;
    Symbol prevtop;
    int level;

    Binder(Object _value, Symbol _prevtop, Binder _tail, int _level) {
        value = _value;
        prevtop = _prevtop;
        tail = _tail;
        level = _level;
    }
}

public class Table {
    private Dictionary<Symbol, Binder> dict = new Hashtable<Symbol, Binder>(); 
    private Symbol top = null;
    private Binder mark = null;

    public Object get(Symbol key) {
        Binder tmp = dict.get(key);
        if (tmp == null) {
            return null;
        } else {
            return tmp.value;
        }
    } 

    public int getLevel(Symbol key) {
        Binder tmp = dict.get(key);
        if (tmp == null) {
            return -1;
        } else {
            return tmp.level;
        }
    }
    
    public void put(Symbol key, Object value, int level) {
        if (key == null) {
            key = Symbol.get("");
        }
        dict.put(key, new Binder(value, top, dict.get(key), level));
        top = key;
    }

    public void beginScope() {
        mark = new Binder(null, top, mark, -2);
        top = null;
    }

    public void endScope() {
        for (; top != null; ) {
            Binder tmp = dict.get(top);
            if (tmp.tail == null) {
                dict.remove(top);
            } else {
                dict.put(top, tmp.tail);
            }
            top = tmp.prevtop;
        }
        top = mark.prevtop;
        mark = mark.tail;
    }

    public Enumeration<Symbol> keys() {
        return dict.keys();
    }
}
