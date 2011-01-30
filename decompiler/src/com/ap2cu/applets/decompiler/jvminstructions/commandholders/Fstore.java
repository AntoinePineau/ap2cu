package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FstoreCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fstore extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fstore";
	}

	protected void registerCommand() {
		setCommand(new FstoreCommand(ExecutionState.getMethodContext()));
	}

}
