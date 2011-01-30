package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IaloadCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Iaload extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IaloadCommand(ExecutionState.getMethodContext()));
	}
}

