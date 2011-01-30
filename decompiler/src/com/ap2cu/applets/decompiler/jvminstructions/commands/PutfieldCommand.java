package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.constantpool.ClassDescription;
import com.ap2cu.applets.decompiler.constantpool.FieldRef;
import com.ap2cu.applets.decompiler.core.DecompilerHelper;
import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Util;

public class PutfieldCommand extends AbstractInstructionCommand {

	public PutfieldCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 2;
	}

	public void execute() {
		boolean doNotPop = GlobalVariableStore.isDoNotPop();
		Behaviour behavior = getContext();
		byte[] info = getCode();
		if (doNotPop == false) {
			int i = getCurrentInstPosInCode();
			int pos = getGenericFinder().getOffset(i);
			i += 2;
			ClassDescription cd = getContext().getClassRef().getCd();
			OperandStack opStack = getStack();
			FieldRef fref = cd.getFieldRefAtCPoolPosition(pos);
			Operand value = opStack.getTopOfStack();
			Operand objRef = opStack.getTopOfStack();

			java.lang.String freftype = fref.getTypeoffield();
			StringBuffer sb = new StringBuffer("");
			DecompilerHelper.checkForImport(objRef.getOperandValue(), sb);
			java.lang.String v = value.getOperandValue();
			if (fref.isBooleanField()) {
				if (v != null && v.equals("1")) {
					v = "true";
				}
				if (v != null && v.equals("0")) {
					v = "false";
				}
			}

			java.lang.String temp = sb.toString().replaceAll("/", ".") + "."
					+ fref.getFieldName() + " =" + v + ";";

			behavior.appendToBuffer( "\n" + Util.formatDecompiledStatement(temp)
					+ "\n");
		}
		if (doNotPop)
			doNotPop = false;

		GlobalVariableStore.setDoNotPop(doNotPop);
	}

}
