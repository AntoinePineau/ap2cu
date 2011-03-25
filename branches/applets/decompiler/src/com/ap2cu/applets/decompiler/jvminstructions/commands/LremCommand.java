package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Constants;

public class LremCommand extends AbstractInstructionCommand {

	public LremCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack opStack = getStack();
		Operand operand1 = opStack.getTopOfStack();
		Operand operand2 = opStack.getTopOfStack();

		Operand op = new Operand();
		op.setOperandType(Constants.IS_CONSTANT_LONG);
		// (Constants.CATEGORY2);
		op.setOperandValue("(" + operand2.getOperandValue() + "%"
				+ operand1.getOperandValue() + ")");
		boolean r = false;// checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
		if (r) {
			if (opStack.size() > 0) {
				java.lang.String str = opStack.getTopOfStack()
						.getOperandValue();
				str = str + op.getOperandValue();
				op.setOperandValue(str);
			}
		}
		opStack.push(op);
	}

}