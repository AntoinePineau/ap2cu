package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.InvokeSpecialCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class InvokeSpecial extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new InvokeSpecialCommand(ExecutionState.getMethodContext()));
	}
}

