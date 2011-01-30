package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LremCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lrem extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LremCommand(ExecutionState.getMethodContext()));
	}
}

