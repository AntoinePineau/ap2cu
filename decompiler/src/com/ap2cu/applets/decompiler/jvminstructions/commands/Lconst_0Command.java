package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Constants;

public class Lconst_0Command extends AbstractInstructionCommand {

	public Lconst_0Command(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack opStack = getStack();
		Operand op = new Operand();
		op.setOperandValue(new Long("0"));
		op.setOperandType(Constants.IS_CONSTANT_LONG);
		boolean r = false;// checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
		if (r) {
			if (opStack.size() > 0) {
				java.lang.String string = opStack.getTopOfStack()
						.getOperandValue();
				string = string + op.getOperandValue();
				op.setOperandValue("0");
			}
		}
		opStack.push(op);
	}

}
