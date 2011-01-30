package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.ISubCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Isub extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new ISubCommand(ExecutionState.getMethodContext()));
	}
}
