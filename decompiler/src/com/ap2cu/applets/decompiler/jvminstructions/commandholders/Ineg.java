package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.InegCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Ineg extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new InegCommand(ExecutionState.getMethodContext()));
	}
}
