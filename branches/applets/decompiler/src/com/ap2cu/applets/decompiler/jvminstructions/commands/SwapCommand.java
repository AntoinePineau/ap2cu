package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class SwapCommand extends AbstractInstructionCommand {

	public SwapCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack stack = getStack();
		Operand op1 = stack.getTopOfStack();
		Operand op2 = stack.getTopOfStack();
		stack.push(op2);
		stack.push(op1);
	}

}
