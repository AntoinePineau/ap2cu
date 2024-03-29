package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.DecompilerHelper;
import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class Dup2Command extends AbstractInstructionCommand {

	public Dup2Command(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		//Behaviour behaviour = getContext();
		int currentForIndex = getCurrentInstPosInCode();
		OperandStack opStack = getStack();
		byte[] info =getCode();
		boolean dupnothandled = GlobalVariableStore.isDupnothandled();
		boolean embeddedANEWARRAY= GlobalVariableStore.isEmbeddedANEWARRAY();
		boolean embeddedNEWARRAY= GlobalVariableStore.isEmbeddedNEWARRAY();
		boolean doNotPop = GlobalVariableStore.isDoNotPop();
		if ((getGenericFinder().isThisInstrStart((currentForIndex - 3)) && info[(currentForIndex - 3)] == JvmOpCodes.ANEWARRAY)
				&& newfound()) {
			dupnothandled = true;
		} else if (newfound()
				&& (DecompilerHelper.checkForSizeOfArrayTimesStack() || DecompilerHelper.prevNewPresent() || GlobalVariableStore.getTernList()
						.size() > 0)) {
			dupnothandled = true;
		} else {
			if (!embeddedANEWARRAY && !embeddedNEWARRAY && (opStack.size() > 0)) {
				Operand op1 = (Operand) opStack.pop();
				Operand op2 = (Operand) opStack.pop();
				opStack.push(op2);
				opStack.push(op1);
				opStack.push(op2);
				opStack.push(op1);
			} else {
				if (embeddedANEWARRAY)
					embeddedANEWARRAY = false;
				if (embeddedNEWARRAY)
					embeddedNEWARRAY = false;

			}
			dupnothandled = false;
			if (doNotPop) {
				doNotPop = false;
			}

		}
		GlobalVariableStore.setDoNotPop(doNotPop);
		GlobalVariableStore.setDupnothandled(dupnothandled);
		GlobalVariableStore.setEmbeddedANEWARRAY(embeddedANEWARRAY);
		GlobalVariableStore.setEmbeddedNEWARRAY(embeddedNEWARRAY);
	}

}
