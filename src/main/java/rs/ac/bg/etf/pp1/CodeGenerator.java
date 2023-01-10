package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;

public class CodeGenerator extends VisitorAdaptor {
    private int mainPC;

    CodeGenerator() {
        // Reset static variables
        Code.pc = 0;
        Code.mainPc = -1;
        Code.dataSize = 0;
        Code.greska = false;

        // Add built-in method char chr(int e)
        SymbolTable.chrObj.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(1);
        Code.put(1);
        Code.put(Code.load_n);
        Code.put(Code.exit);
        Code.put(Code.return_);

        // Add build-in method int ord(char c)
        SymbolTable.ordObj.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(1);
        Code.put(1);
        Code.put(Code.load_n);
        Code.put(Code.exit);
        Code.put(Code.return_);

        // Add built-in method int len(char arr[]) / int len(int arr[])
        SymbolTable.lenObj.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(1);
        Code.put(1);
        Code.put(Code.load_n);
        Code.put(Code.arraylength);
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

    public int getMainPC() {
        return mainPC;
    }

  /*  public void visit(MethodTypeName methodTypeName) {
        if ("main".equalsIgnoreCase(methodTypeName.getMethodName())) {
            mainPC = Code.pc;
        }

        Code.put(Code.enter);
        Code.put(0);
        Code.put(0);
    } */
}
