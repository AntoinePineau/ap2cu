package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.SaloadCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Saload extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new SaloadCommand(ExecutionState.getMethodContext()));
	}
}

