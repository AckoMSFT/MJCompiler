package rs.ac.bg.etf.pp1.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rs.etf.pp1.mj.runtime.Code;

import java.util.ArrayList;
import java.util.Stack;

public class BranchJumpAddressStack {

    static Logger logger = LogManager.getLogger(BranchJumpAddressStack.class);

    Stack<ArrayList<Integer>> trueJumpAddressStack, falseJumpAddressStack;

    public BranchJumpAddressStack() {
        trueJumpAddressStack = new Stack<>();
        falseJumpAddressStack = new Stack<>();
    }

    public void pop() {
        if (trueJumpAddressStack.empty()) {
            return;
        } else {
            trueJumpAddressStack.pop();
        }

        if (falseJumpAddressStack.empty()) {
            return;
        } else {
            falseJumpAddressStack.pop();
        }
    }

    public void pushNewEntry() {
        trueJumpAddressStack.push(new ArrayList<>());
        falseJumpAddressStack.push(new ArrayList<>());
    }

    public void pushTrueJump(int trueJumpAddress) {
        ArrayList<Integer> currentTrueJumpAddressList = trueJumpAddressStack.peek();
        currentTrueJumpAddressList.add(trueJumpAddress);
    }

    public void pushFalseJump(int falseJumpAddress) {
        ArrayList<Integer> currentFalseJumpAddressList = falseJumpAddressStack.peek();
        currentFalseJumpAddressList.add(falseJumpAddress);
    }

    public void patchTrueJumps() {
        if (trueJumpAddressStack.empty()) {
            return;
        }

        ArrayList<Integer> currentTrueJumpAddressList = trueJumpAddressStack.peek();
        for (Integer trueJumpAddress : currentTrueJumpAddressList) {
            Code.fixup(trueJumpAddress);
        }
        currentTrueJumpAddressList.clear();
    }

    public void patchFalseJumps() {
        if (falseJumpAddressStack.empty()) {
            return;
        }

        ArrayList<Integer> currentFalseJumpAddressList = falseJumpAddressStack.peek();
        for (Integer falseJumpAddress: currentFalseJumpAddressList) {
            Code.fixup(falseJumpAddress);
        }
        currentFalseJumpAddressList.clear();
    }
}
