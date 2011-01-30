package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LmulCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lmul extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LmulCommand(ExecutionState.getMethodContext()));
	}
}

