package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.L2dCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class L2d extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new L2dCommand(ExecutionState.getMethodContext()));
	}
}

