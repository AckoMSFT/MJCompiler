package rs.ac.bg.etf.pp1.util;

import rs.etf.pp1.symboltable.concepts.Obj;

import java.util.ArrayList;
import java.util.Stack;

public class ActualParametersStack {
    Stack<ArrayList<Obj>> actualParametersStack;

    public ActualParametersStack() {
        this.actualParametersStack = new Stack<>();
    }

    public ArrayList<Obj> pop() {
        if (actualParametersStack.empty()) {
            return null;
        }

        return actualParametersStack.pop();
    }

    public ArrayList<Obj> peek() {
        if (actualParametersStack.empty()) {
            return null;
        }

        return actualParametersStack.peek();
    }

    public void push(Obj actualParameter) {
        if (actualParametersStack.empty()) {
            actualParametersStack.push(new ArrayList<>());
        }

        ArrayList<Obj> currentActualParameters = actualParametersStack.peek();
        currentActualParameters.add(actualParameter);
    }

    public void push(ArrayList<Obj> actualParameters) {
        actualParametersStack.push(actualParameters);
    }

    public int size() {
        return actualParametersStack.size();
    }

    public boolean empty() {
        return actualParametersStack.empty();
    }
}
