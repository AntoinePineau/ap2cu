package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LorCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lor extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LorCommand(ExecutionState.getMethodContext()));
	}
}

