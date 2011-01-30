package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FnegCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fneg extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fneg";
	}

	protected void registerCommand() {
		setCommand(new FnegCommand(ExecutionState.getMethodContext()));
	}

}
