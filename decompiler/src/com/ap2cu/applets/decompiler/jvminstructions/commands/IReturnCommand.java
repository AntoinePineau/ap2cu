package com.ap2cu.applets.decompiler.jvminstructions.commands;

import java.util.Iterator;
import java.util.Map;

import com.ap2cu.applets.decompiler.core.DecompilerHelper;
import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Util;


public class IReturnCommand extends AbstractInstructionCommand {

	public IReturnCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		boolean oktoadd = true;
		Behaviour behavior = getContext();
		
		String tempString = "";
		OperandStack opStack = getStack();
		int currentForIndex = getCurrentInstPosInCode();
		int i = currentForIndex;
		Map returnsAtI = GlobalVariableStore.getReturnsAtI();
		Iterator mapIT = returnsAtI.entrySet().iterator();
		while (mapIT.hasNext()) {
			Map.Entry entry = (Map.Entry) mapIT.next();
			Object key = entry.getKey();
			Object retStatus = entry.getValue().toString();
			if (key instanceof Integer) {
				Integer pos = (Integer) key;
				int temp = pos.intValue();
				if (temp == i) {
					if (retStatus.equals("true")) {

						oktoadd = false;
						break;
					}
				}
			}

		}

		if (!oktoadd) {
			returnsAtI.remove(new Integer(i));
		}

		if (oktoadd && opStack.size() > 0) {
			Operand op = (Operand) opStack.pop();
			boolean bool = DecompilerHelper.isMethodRetBoolean(getContext());
			if (bool) {
				if (op.getOperandValue().equals("1")) {
					op.setOperandValue("true");
				} else if (op.getOperandValue().equals("0")) {
					op.setOperandValue("false");
				}
			}
			tempString = "return " + op.getOperandValue() + ";\n";
			behavior.appendToBuffer( Util.formatDecompiledStatement(tempString));
		}
		
	}

}
