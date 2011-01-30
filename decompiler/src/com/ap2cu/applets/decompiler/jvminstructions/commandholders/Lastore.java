package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LastoreCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lastore extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LastoreCommand(ExecutionState.getMethodContext()));
	}
}

