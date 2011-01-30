package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.ImulCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Imul extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new ImulCommand(ExecutionState.getMethodContext()));
	}
}

