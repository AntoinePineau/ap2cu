package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Dup2x2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Dup2x2 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Dup2x2";
	}

	protected void registerCommand() {
		setCommand(new Dup2x2Command(ExecutionState.getMethodContext()));
	}

}
