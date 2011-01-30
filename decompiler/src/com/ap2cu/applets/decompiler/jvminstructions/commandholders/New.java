package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.NewCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class New extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new NewCommand(ExecutionState.getMethodContext()));
	}
}

