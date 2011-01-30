package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Dup2x1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Dup2x1 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Dup2x1";
	}

	protected void registerCommand() {
		setCommand(new Dup2x1Command(ExecutionState.getMethodContext()));
	}

}
