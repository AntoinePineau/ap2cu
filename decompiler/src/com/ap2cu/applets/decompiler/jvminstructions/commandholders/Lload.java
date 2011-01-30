package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LloadCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lload extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LloadCommand(ExecutionState.getMethodContext()));
	}
}

