package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LreturnCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lreturn extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LreturnCommand(ExecutionState.getMethodContext()));
	}
}

