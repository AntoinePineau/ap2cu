package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.F2LCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class F2L extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "F2d";
	}

	protected void registerCommand() {
		setCommand(new F2LCommand(ExecutionState.getMethodContext()));
	}

}
