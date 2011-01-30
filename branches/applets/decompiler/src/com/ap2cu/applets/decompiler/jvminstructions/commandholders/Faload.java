package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FaloadCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Faload extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Faload";
	}

	protected void registerCommand() {
		setCommand(new FaloadCommand(ExecutionState.getMethodContext()));
	}

}
