package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.constantpool.ClassDescription;
import com.ap2cu.applets.decompiler.constantpool.ClassInfo;
import com.ap2cu.applets.decompiler.constantpool.FieldRef;
import com.ap2cu.applets.decompiler.core.DecompilerHelper;
import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Util;

public class PutstaticCommand extends AbstractInstructionCommand {

	public PutstaticCommand(Behaviour context) {
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
			/*
			 * parsedString+="PUTSTATIC\t"; parsedString+="#"+pos;
			 * parsedString+="\n"; parsedString+="\t";parsedString+="\t";
			 */
			ClassDescription cd = getContext().getClassRef().getCd();
			OperandStack opStack = getStack();
			FieldRef fref = cd.getFieldRefAtCPoolPosition(pos);
			Operand value = opStack.getTopOfStack();
			java.lang.String freftype = fref.getTypeoffield();

			// For the code statement
			int classpointer = fref.getClassPointer();
			ClassInfo cinfo = cd.getClassInfoAtCPoolPosition(classpointer);
			java.lang.String classname = cd.getUTF8String(cinfo
					.getUtf8pointer());
			java.lang.String v = value.getOperandValue().toString();
			if (v.indexOf("(") == -1 && v.indexOf(")") != -1) {
				v = v.replaceAll("\\)", "");

			}
			v = v.trim();
			StringBuffer sb = new StringBuffer("");
			DecompilerHelper.checkForImport(classname, sb);
			v = value.getOperandValue();
			if (fref.isBooleanField()) {
				if (v != null && v.equals("1")) {
					v = "true";
				}
				if (v != null && v.equals("0")) {
					v = "false";
				}
			}

			java.lang.String temp = sb.toString().replaceAll("/", ".") + "."
					+ fref.getFieldName() + " = " + v + ";";
			behavior.appendToBuffer( "\n" + Util.formatDecompiledStatement(temp)
					+ "\n");
		}
		if (doNotPop)
			doNotPop = false;
		GlobalVariableStore.setDoNotPop(doNotPop);
		
	}

}
