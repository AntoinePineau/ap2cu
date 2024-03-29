package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.blockhelpers.IFHelper;
import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.core.ShortcutAnalyser;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Constants;

public class LcmpCommand extends AbstractInstructionCommand {

	public LcmpCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		int currentForIndex = getCurrentInstPosInCode();
		int i = currentForIndex;
		int j;
		OperandStack stack = getStack();
		Operand op = (Operand) stack.pop();
		Operand op1 = (Operand) stack.pop();
		Operand op2 = new Operand();
		op2.setCategory(Constants.CATEGORY1);
		op2.setOperandType(Constants.IS_CONSTANT_INT);
		j = i + 1;
		byte[] info = getCode();
		int nextInstruction = info[j];
		boolean sh = IFHelper.isIFShortcutORComp(info, j);
		ShortcutAnalyser sanalyser = getContext().getShortCutAnalyser();
		boolean invert = sanalyser.isLastIfInChain(j);
		if (!invert) {
			java.lang.String connector = sanalyser.getConnector(j);
			if (connector != null
					&& connector.trim().equals(ShortcutAnalyser.AND)) {
				invert = true;
			}
		}
        if (!sh) {
            if (getGenericFinder().isThisInstrStart((currentForIndex + 1))) {
                if (getBranchFinder().isInstructionIF((currentForIndex + 1))){
                    int ifclose = IFHelper.getIfCloseNumberForThisIF(info, (currentForIndex + 1));
                    ifclose = ifclose - 3;
                    if (getGenericFinder().isThisInstrStart(ifclose)) {
                        if (getBranchFinder().isInstructionIF(ifclose) && ifclose != j) {
                            sh = true;
                        }
                    }
                }
            }
        }
		switch (nextInstruction) {
		case JvmOpCodes.IFEQ:
			if (!sh)
				op2.setOperandValue(op1.getOperandValue() + "!="
						+ op.getOperandValue());
			else {
				if (!invert)
					op2.setOperandValue(op1.getOperandValue() + "=="
							+ op.getOperandValue());
				else
					op2.setOperandValue(op1.getOperandValue() + "!="
							+ op.getOperandValue());
			}

			break;
		case JvmOpCodes.IFNE:
			if (!sh)
				op2.setOperandValue(op1.getOperandValue() + "=="
						+ op.getOperandValue());
			else {
				if (!invert)
					op2.setOperandValue(op1.getOperandValue() + "!="
							+ op.getOperandValue());
				else
					op2.setOperandValue(op1.getOperandValue() + "=="
							+ op.getOperandValue());
			}
			break;
		case JvmOpCodes.IFLT:
			if (!sh)
				op2.setOperandValue(op1.getOperandValue() + ">="
						+ op.getOperandValue());
			else {
				if (!invert)
					op2.setOperandValue(op1.getOperandValue() + "<"
							+ op.getOperandValue());
				else
					op2.setOperandValue(op1.getOperandValue() + ">="
							+ op.getOperandValue());
			}
			break;
		case JvmOpCodes.IFGE:
			if (!sh)
				op2.setOperandValue(op1.getOperandValue() + "<"
						+ op.getOperandValue());
			else {
				if (!invert)
					op2.setOperandValue(op1.getOperandValue() + ">="
							+ op.getOperandValue());
				else
					op2.setOperandValue(op1.getOperandValue() + "<"
							+ op.getOperandValue());
			}
			break;
		case JvmOpCodes.IFGT:
			if (!sh)
				op2.setOperandValue(op1.getOperandValue() + "<="
						+ op.getOperandValue());
			else {
				if (!invert)
					op2.setOperandValue(op1.getOperandValue() + ">"
							+ op.getOperandValue());
				else
					op2.setOperandValue(op1.getOperandValue() + "<="
							+ op.getOperandValue());
			}
			break;
		case JvmOpCodes.IFLE:
			if (!sh)
				op2.setOperandValue(op1.getOperandValue() + ">"
						+ op.getOperandValue());
			else {
				if (!invert)
					op2.setOperandValue(op1.getOperandValue() + "<="
							+ op.getOperandValue());
				else
					op2.setOperandValue(op1.getOperandValue() + ">"
							+ op.getOperandValue());
			}
			break;
		}

		stack.push(op2);
	}

}
