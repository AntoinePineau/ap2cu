package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.D2LCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class D2L extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "D2L";
	}

	protected void registerCommand() {
		setCommand(new D2LCommand(ExecutionState.getMethodContext()));
	}

}
