package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class InegCommand extends AbstractInstructionCommand {

	public InegCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack opStack = getStack();
		Operand op = (Operand) opStack.pop();

		Operand op1 = new Operand();
		op1.setOperandValue("-" + "(" + op.getOperandValue() + ")");
		boolean r = false;//checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
		if (r) {
			if (opStack.size() > 0) {
				java.lang.String str = opStack.getTopOfStack()
						.getOperandValue();
				str = str + op1.getOperandValue();
				op1.setOperandValue(str);
			}
		}
		opStack.push(op1);
	}

}
