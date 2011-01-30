package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LshrCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lshr extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LshrCommand(ExecutionState.getMethodContext()));
	}
}

