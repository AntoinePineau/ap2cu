package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.SwapCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Swap extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new SwapCommand(ExecutionState.getMethodContext()));
	}
}

