package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.L2fCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class L2f extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new L2fCommand(ExecutionState.getMethodContext()));
	}
}

