package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FreturnCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Freturn extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Freturn";
	}

	protected void registerCommand() {
		setCommand(new FreturnCommand(ExecutionState.getMethodContext()));
	}

}
