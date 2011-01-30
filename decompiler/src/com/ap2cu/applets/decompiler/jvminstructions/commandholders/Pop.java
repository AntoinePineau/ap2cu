package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.PopCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Pop extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new PopCommand(ExecutionState.getMethodContext()));
	}
}
