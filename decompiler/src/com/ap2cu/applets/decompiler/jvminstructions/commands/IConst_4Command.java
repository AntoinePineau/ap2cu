package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class IConst_4Command extends AbstractInstructionCommand {

	public IConst_4Command(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack opStack = getStack();
		Operand op = new Operand();
		op.setOperandValue("4");
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
