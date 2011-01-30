package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.constantpool.ClassDescription;
import com.ap2cu.applets.decompiler.constantpool.DoublePrimitive;
import com.ap2cu.applets.decompiler.constantpool.LongPrimitive;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Constants;

public class Ldc2_wCommand extends AbstractInstructionCommand {

	public Ldc2_wCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 2;
	}

	public void execute() {
		int i = getCurrentInstPosInCode();
		int opValueI = getGenericFinder().getOffset(i);
		i += 2;
		LongPrimitive constLong = null;
		DoublePrimitive constDouble = null;
		int type = -1;
		ClassDescription cd = getContext().getClassRef().getCd();
		constLong = cd.getLongPrimitiveAtCPoolPosition(opValueI);
		if (constLong == null) {
			constDouble = cd.getDoublePrimitiveAtCPoolPosition(opValueI);
			if (constDouble == null) {
				// ERROR CONDITION
			} else {
				type = Constants.IS_CONSTANT_DOUBLE;
			}
		} else {
			type = Constants.IS_CONSTANT_LONG;
		}
		Operand op = new Operand();
		op.setOperandType(type);
		if (type == Constants.IS_CONSTANT_DOUBLE) {
			op.setOperandValue(new Double(constDouble.getValue()));
		}
		if (type == Constants.IS_CONSTANT_LONG) {
			op.setOperandValue(new Long(constLong.getValue()) + "L ");
		}
		OperandStack opStack = getStack();
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
