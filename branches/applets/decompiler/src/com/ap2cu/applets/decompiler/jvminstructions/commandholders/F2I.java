package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.F2ICommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class F2I extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "F2d";
	}

	protected void registerCommand() {
		setCommand(new F2ICommand(ExecutionState.getMethodContext()));
	}

}
