package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.commonutil.Numbers;
import com.ap2cu.applets.decompiler.constantpool.CPString;
import com.ap2cu.applets.decompiler.constantpool.ClassDescription;
import com.ap2cu.applets.decompiler.constantpool.FloatPrimitive;
import com.ap2cu.applets.decompiler.constantpool.IntPrimitive;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.ui.util.UIUtil;
import com.ap2cu.applets.decompiler.util.Constants;
import com.ap2cu.applets.decompiler.util.Util;

public class LdcCommand extends AbstractInstructionCommand {

	public LdcCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 1;
	}

	public void execute() {
		int i = getCurrentInstPosInCode();
		byte[] info = getCode();
		int opValueI = info[++i];
		// Important Fix
		if (opValueI < 0)
			opValueI += 256;

		int type = -1;
		FloatPrimitive constFloat = null;
		java.lang.String stringLiteral = "";
		OperandStack opStack = getStack();
		ClassDescription cd = getContext().getClassRef().getCd();
		IntPrimitive constInt = cd.getINTPrimitiveAtCPoolPosition(opValueI);
		if (constInt == null) {
			constFloat = cd.getFloatPrimitiveAtCPoolPosition(opValueI);
			if (constFloat == null) {
				CPString constString = cd.getStringsAtCPoolPosition(opValueI);
				stringLiteral = cd.getUTF8String(constString.getUtf8pointer());
				if (constString == null) {
					// ERROR CONDITION
				} else {
					type = Constants.IS_OBJECT_REF;
				}
			} else {
				type = Constants.IS_CONSTANT_FLOAT;
			}
		} else {
			type = Constants.IS_CONSTANT_INT;
		}
		Operand op = new Operand();
		op.setOperandType(type);
		if (type == Constants.IS_CONSTANT_INT) {
			op.setOperandValue(new Integer(constInt.getValue()));
			op.setClassType("int");
		}
		if (type == Constants.IS_CONSTANT_FLOAT) {

			op.setOperandValue(constFloat.getValue() + "f ");
			op.setClassType("float");
		}
		if (type == Constants.IS_OBJECT_REF) {

			java.lang.String nonascii = UIUtil.getUIUtil()
					.getInterpretNonAscii();
			if (nonascii.equals("true")) {
				StringBuffer tp = new StringBuffer("");

				boolean sf = Numbers.shouldValueBeFormattedForNonAscii(
						stringLiteral, "String", tp);
				if (sf) {
					stringLiteral = Util.formatForUTF(stringLiteral, "String",
							tp);
				}
			} else {
				stringLiteral = Util.returnUnInterpretedNonAscii(stringLiteral);
			}
			op.setOperandValue("\"" + stringLiteral + "\"");
			op.setClassType("java.lang.String");
		}
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
