package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FloadCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fload extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fload";
	}

	protected void registerCommand() {
		setCommand(new FloadCommand(ExecutionState.getMethodContext()));
	}

}
