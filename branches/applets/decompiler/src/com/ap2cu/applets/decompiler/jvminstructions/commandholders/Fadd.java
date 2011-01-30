package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FaddCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fadd extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fadd";
	}

	protected void registerCommand() {
		setCommand(new FaddCommand(ExecutionState.getMethodContext()));
	}

}
