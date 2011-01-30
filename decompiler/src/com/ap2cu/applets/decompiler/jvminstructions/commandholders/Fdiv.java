package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FdivCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fdiv extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fdiv";
	}

	protected void registerCommand() {
		setCommand(new FdivCommand(ExecutionState.getMethodContext()));
	}

}
