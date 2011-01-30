package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class Dup2x1Command extends AbstractInstructionCommand {

	public Dup2x1Command(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack opStack = getStack();
		Operand op1 = (Operand) opStack.pop();
		Operand op2 = (Operand) opStack.pop();
		Operand op3 = (Operand) opStack.pop();
		opStack.push(op2);
		opStack.push(op1);
		opStack.push(op3);
		opStack.push(op2);
		opStack.push(op1);
		if (GlobalVariableStore.isDoNotPop()) {
			GlobalVariableStore.setDoNotPop(false);
		}
	}

}
