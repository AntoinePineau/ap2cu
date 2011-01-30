package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.BipushCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Bipush extends AbstractInstructionCommandHolder {

	public Bipush() {
	}

	protected String getName() {
		return "bipush";
	}

	protected void registerCommand() {
		BipushCommand command = new BipushCommand(ExecutionState.getMethodContext());
		setCommand(command);
	}

}
