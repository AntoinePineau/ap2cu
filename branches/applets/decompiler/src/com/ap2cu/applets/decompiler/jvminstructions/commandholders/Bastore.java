package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.BastoreCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Bastore extends AbstractInstructionCommandHolder {

	public Bastore() {
	}

	protected String getName() {
		return "Bastore";
	}

	protected void registerCommand() {
		BastoreCommand command = new BastoreCommand(ExecutionState.getMethodContext());
		setCommand(command);
	}

}
