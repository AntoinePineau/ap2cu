package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LdivCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Ldiv extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LdivCommand(ExecutionState.getMethodContext()));
	}
}

