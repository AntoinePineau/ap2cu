package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LandCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Land extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LandCommand(ExecutionState.getMethodContext()));
	}
}

