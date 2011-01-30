package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FremCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Frem extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Frem";
	}

	protected void registerCommand() {
		setCommand(new FremCommand(ExecutionState.getMethodContext()));
	}

}
