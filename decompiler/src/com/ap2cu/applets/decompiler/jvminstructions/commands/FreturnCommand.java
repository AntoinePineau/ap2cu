package com.ap2cu.applets.decompiler.jvminstructions.commands;

import java.util.Iterator;
import java.util.Map;

import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Util;


public class FreturnCommand extends AbstractInstructionCommand {

	public FreturnCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		int currentForIndex = getCurrentInstPosInCode();
		int i = currentForIndex;
		boolean oktoadd = true;
		Behaviour behaviour = getContext();
		Iterator mapIT = GlobalVariableStore.getReturnsAtI().entrySet().iterator();
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
			GlobalVariableStore.getReturnsAtI().remove(new Integer(i));
		}
		OperandStack opStack=getStack();
		
		if (oktoadd && opStack.size() > 0) {
			Operand op = (Operand) opStack.pop();
			String tempString = "return " + op.getOperandValue().toString() + ";\n";
			behaviour.appendToBuffer( Util.formatDecompiledStatement(tempString));
		}
		
	}

}
