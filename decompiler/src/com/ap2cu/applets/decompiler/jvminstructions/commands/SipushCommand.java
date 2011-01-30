package com.ap2cu.applets.decompiler.jvminstructions.commands;

import java.util.Hashtable;

import com.ap2cu.applets.decompiler.commonutil.Numbers;
import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.ui.util.UIUtil;


public class SipushCommand extends AbstractInstructionCommand {

	public SipushCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 2;
	}

	public void execute() {
		Hashtable pushTypes=GlobalVariableStore.getPushTypes();
		int currentForIndex = getCurrentInstPosInCode();
		int opValueI = getGenericFinder().getOffset(currentForIndex);
		int sipushvalue = opValueI;
		java.lang.String sopValueI = "";

		java.lang.String nonascii = UIUtil.getUIUtil().getInterpretNonAscii();
		StringBuffer sbf = new StringBuffer("");
		sopValueI = Numbers.formatCharForNonAsciiValue(opValueI, sbf);
		if (sbf.toString().equals("nonascii")) {
			if (nonascii.equals("true")) {

			} else {
				sopValueI = "" + opValueI;
			}
		}
		Operand op = new Operand();
		java.lang.String tp = null;
		if (pushTypes != null) {
			tp = (java.lang.String) pushTypes.get(new Integer(currentForIndex));
			if (tp != null) {
				tp = "(" + tp + ")" + sopValueI;
			}

		}

		if (tp != null)

			op.setOperandValue(tp);// // new Integer(opValueI));
		else
			op.setOperandValue("" + sopValueI);
		boolean r = false;//heckIFLoadInstIsPartOFTernaryCond(currentForIndex);
		OperandStack opStack =getStack();
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
