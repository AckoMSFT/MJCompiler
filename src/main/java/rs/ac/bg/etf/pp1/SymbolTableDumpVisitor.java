package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

import java.util.Iterator;

public class SymbolTableDumpVisitor extends DumpSymbolTableVisitor {
    @Override
    public void visitStructNode(Struct structToVisit) {
        switch (structToVisit.getKind()) {
            case 0:
                this.output.append("notype");
                break;
            case 1:
                this.output.append("int");
                break;
            case 2:
                this.output.append("char");
                break;
            case 3:
                this.output.append("Arr of ");
                switch (structToVisit.getElemType().getKind()) {
                    case 0:
                        this.output.append("notype");
                        return;
                    case 1:
                        this.output.append("int");
                        return;
                    case 2:
                        this.output.append("char");
                        return;
                    case 3:
                    default:
                        return;
                    case 4:
                        this.output.append("Class");
                        return;
                    case 5:
                        this.output.append("bool");
                        return;
                }
            case 4:
                this.output.append("Class [");

                for (Obj obj : structToVisit.getMembers()) {
                    obj.accept(this);
                }

                this.output.append("]");
            case 5:
                this.output.append("bool");
        }
    }
}
