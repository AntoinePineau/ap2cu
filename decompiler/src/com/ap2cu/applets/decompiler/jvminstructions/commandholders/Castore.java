package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.CastoreCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Castore extends AbstractInstructionCommandHolder {

	public Castore() {
	}

	protected String getName() {
		return "Castore";
	}

	protected void registerCommand() {
		CastoreCommand command = new CastoreCommand(ExecutionState.getMethodContext());
		setCommand(command);
	}

}
