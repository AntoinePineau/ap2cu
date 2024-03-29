package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.commonutil.Numbers;
import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.ui.util.UIUtil;

public class BipushCommand extends AbstractInstructionCommand {

	public BipushCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 1;
	}

	public void execute() {
		byte[] info = getContext().getCode();
		int currentForIndex = getCurrentInstPosInCode();
		int opValueB = info[(currentForIndex + 1)];
		OperandStack opStack = getContext().getOpStack();
		java.lang.String nonascii = UIUtil.getUIUtil().getInterpretNonAscii();
		java.lang.String sopValueB = "";
		StringBuffer sbf = new StringBuffer("");
		sopValueB = Numbers.formatCharForNonAsciiValue(opValueB, sbf);
		if (sbf.toString().equals("nonascii")) {
			if (nonascii.equals("true")) {

			} else {
				sopValueB = "" + opValueB;
			}
		}
		Operand op = new Operand();
		java.lang.String tp = null;
		if (GlobalVariableStore.getPushTypes() != null) {
			tp = (java.lang.String) GlobalVariableStore.getPushTypes().get(
					new Integer(currentForIndex));
			if (tp != null) {
				tp = "(" + tp + ")" + sopValueB;
			}

		}
		if (tp != null) {
			op.setOperandValue(tp);// // new Integer(opValueI));
		} else

		{
			op.setOperandValue("" + sopValueB);
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
