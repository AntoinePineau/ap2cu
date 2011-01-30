package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FastoreCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fastore extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fastore";
	}

	protected void registerCommand() {
		setCommand(new FastoreCommand(ExecutionState.getMethodContext()));
	}

}
