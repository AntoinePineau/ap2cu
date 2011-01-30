package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Constants;

public class CaloadCommand extends AbstractInstructionCommand {

	public CaloadCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack stack = getContext().getOpStack();
		Operand op = (Operand) stack.pop();
		Operand op1 = (Operand) stack.pop();
		int currentForIndex = getCurrentInstPosInCode();
		Operand op2 = createOperand(op1.getOperandValue() + "["
				+ op.getOperandValue() + "]", Constants.IS_CONSTANT_CHARACTER,
				Constants.CATEGORY1);
		boolean r = false;// checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
		if (r) {
			if (stack.size() > 0) {
				java.lang.String str = stack.getTopOfStack().getOperandValue();
				str = str + op2.getOperandValue();
				op2.setOperandValue(str);
			}
		}
		stack.push(op2);
	}
}
