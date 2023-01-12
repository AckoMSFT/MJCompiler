package rs.ac.bg.etf.pp1.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;

import java.util.ArrayList;
import java.util.Stack;

public class LoopJumpAddressStack {

    static Logger logger = LogManager.getLogger(LoopJumpAddressStack.class);

    Stack<ArrayList<Integer>> continueJumpAddressStack, breakJumpAddressStack;

    public LoopJumpAddressStack() {
        continueJumpAddressStack = new Stack<>();
        breakJumpAddressStack = new Stack<>();
    }

    public void pop() {
        if (continueJumpAddressStack.empty()) {
            return;
        } else {
            continueJumpAddressStack.pop();
        }

        if (breakJumpAddressStack.empty()) {
            return;
        } else {
            breakJumpAddressStack.pop();
        }
    }

    public void pushNewEntry() {
        continueJumpAddressStack.push(new ArrayList<>());
        breakJumpAddressStack.push(new ArrayList<>());
    }

    public void pushContinueJumpAddress(int continueJumpAddress) {
        ArrayList<Integer> currentContinueJumpAddressList = continueJumpAddressStack.peek();
        currentContinueJumpAddressList.add(continueJumpAddress);
    }

    public void pushBreakJumpAddress(int breakJumpAddress) {
        ArrayList<Integer> currentBreakJumpAddressList = breakJumpAddressStack.peek();
        currentBreakJumpAddressList.add(breakJumpAddress);
    }

    public void patchContinueAddressJumps() {
        if (continueJumpAddressStack.empty()) {
            return;
        }

        ArrayList<Integer> currentContinueJumpAddressList = continueJumpAddressStack.peek();
        for (Integer continueJumpAddress: currentContinueJumpAddressList) {
            Code.fixup(continueJumpAddress);
        }

        continueJumpAddressStack.clear();
    }

    public void patchBreakAddressJumps() {
        if (breakJumpAddressStack.empty()) {
            return;
        }

        ArrayList<Integer> currentBreakJumpAddressList = breakJumpAddressStack.peek();
        for (Integer breakJumpAddress: currentBreakJumpAddressList) {
            Code.fixup(breakJumpAddress);
        }

        continueJumpAddressStack.clear();
    }
}
