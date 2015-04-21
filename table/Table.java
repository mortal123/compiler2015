package compiler2015.table;

import compiler2015.ast.*;
import java.util.*;

class Binder {
    Object value;
    Binder tail;
    Symbol prevtop;

    Binder(Object _value, Symbol _prevtop, Binder _tail) {
        value = _value;
        prevtop = _prevtop;
        tail = _tail;
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

    public void put(Symbol key, Object value) {
        if (key == null) {
            key = Symbol.get("");
        }
        Binder tmp = new Binder(value, top, dict.get(key));
        top = key;
    }

    public void beginScope() {
        mark = new Binder(null, top, mark);
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
