package com.ap2cu.applets.decompiler.jvminstructions.commands;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ap2cu.applets.decompiler.blockhelpers.BranchHelper;
import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Util;

public class ReturnCommand extends AbstractInstructionCommand {

	public ReturnCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		Behaviour behaviour = getContext();
		java.lang.String temp = behaviour.getReturnType();
		// Empty Stack Of This method
		OperandStack currentstack = behaviour.getOpStack();
		boolean check = currentstack.emptyMe();

		boolean oktoadd = true;
		HashMap returnsAtI = GlobalVariableStore.getReturnsAtI();
		Iterator mapIT = returnsAtI.entrySet().iterator();
		int currentForIndex = getCurrentInstPosInCode();
		int prev = currentForIndex - 1;
		if (getGenericFinder().isThisInstrStart(prev)) {
			if (getCode()[prev] == JvmOpCodes.ATHROW) {
				oktoadd = false;
			}
		}

		if (oktoadd) {
			while (mapIT.hasNext()) {
				Map.Entry entry = (Map.Entry) mapIT.next();
				Object key = entry.getKey();
				Object retStatus = entry.getValue().toString();
				if (key instanceof Integer) {
					Integer position = (Integer) key;
					int posValue = position.intValue();
					if (posValue == currentForIndex) {
						if (retStatus.equals("true")) {

							oktoadd = false;
							break;
						}
					}
				}

			}
		}

		if(oktoadd){
			if(getGenericFinder().isPreviousInst(currentForIndex, currentForIndex - 1)){
				byte[] info = behaviour.getCode();
				if(info[currentForIndex - 1] == JvmOpCodes.RETURN)
					oktoadd = false;
			}
		}
		
		if (!oktoadd) {
			returnsAtI.remove(new Integer(currentForIndex));
		}
		

		Behaviour behavior = getContext();
		if (oktoadd && behaviour.getBehaviourName().equals("static") == false) {
			oktoadd = BranchHelper.addReturnInIfBlock(currentForIndex);
			if (oktoadd) {
				java.lang.String tempString = Util
						.formatDecompiledStatement("return;\n");
				behavior.appendToBuffer("\n"+tempString);
				returnsAtI.put(new Integer(currentForIndex), "true");
			}
		}

	}

}
