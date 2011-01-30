package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Dup2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Dup2 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Dup2";
	}

	protected void registerCommand() {
		setCommand(new Dup2Command(ExecutionState.getMethodContext()));
	}

}
