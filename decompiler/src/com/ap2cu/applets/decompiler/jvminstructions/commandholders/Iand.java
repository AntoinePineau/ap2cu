package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IandCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Iand extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IandCommand(ExecutionState.getMethodContext()));
	}
}

