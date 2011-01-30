package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LsubCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lsub extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LsubCommand(ExecutionState.getMethodContext()));
	}
}

