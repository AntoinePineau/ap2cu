package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class BaloadCommand extends AbstractInstructionCommand {

	public BaloadCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack stack = getContext().getOpStack();
		Operand op = (Operand) stack.pop();
		Operand op1 = (Operand) stack.pop();
		Operand op2 = new Operand();
		op2.setOperandValue(op1.getOperandValue() + "[" + op.getOperandValue()
				+ "]");
		boolean r = false;// checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
		if (r) {
			if (stack.size() > 0) {
				java.lang.String str = stack.getTopOfStack()
						.getOperandValue();
				str = str + op2.getOperandValue();
				op2.setOperandValue(str);
			}
		}
		stack.push(op2);
	}

}
