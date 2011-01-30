package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Util;

public class MonitorEnterCommand extends AbstractInstructionCommand {

	public MonitorEnterCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		Operand op = getStack().getTopOfStack();
		String tempString = "synchronized(" + op.getOperandValue() + ")\n{\n";
		Behaviour behavior = getContext();
		behavior.appendToBuffer( Util.formatDecompiledStatement(tempString));
		GlobalVariableStore.setCurrentMonitorEnterPos(getCurrentInstPosInCode());

	}

}
