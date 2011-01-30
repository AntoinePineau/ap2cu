package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LxorCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lxor extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LxorCommand(ExecutionState.getMethodContext()));
	}
}

