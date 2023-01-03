package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class MicroJavaSymbol extends Obj {
    public MicroJavaSymbol(int kind, String name, Struct type) {
        super(kind, name, type);
    }

    public MicroJavaSymbol(int kind, String name, Struct type, int adr, int level) {
        super(kind, name, type, adr, level);
    }
}
