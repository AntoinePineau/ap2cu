package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LaloadCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Laload extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LaloadCommand(ExecutionState.getMethodContext()));
	}
}

