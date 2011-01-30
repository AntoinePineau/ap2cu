package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Constants;

public class ImulCommand extends AbstractInstructionCommand {

	public ImulCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack opStack = getStack();
		Operand op, op1 , op2;
		op = (Operand) opStack.pop();
		op1 = (Operand) opStack.pop();

		op2 = new Operand();
		op2.setOperandValue(op1.getOperandValue() + "*" + op.getOperandValue());
		op2.setOperandType(Constants.IS_CONSTANT_INT);
		op2.setCategory(Constants.CATEGORY1);
		boolean r = false;//checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
		if (r) {
			if (opStack.size() > 0) {
				java.lang.String str = opStack.getTopOfStack()
						.getOperandValue();
				str = str + op2.getOperandValue();
				op2.setOperandValue(str);
			}
		}
		opStack.push(op2);
	}

}
