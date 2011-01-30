package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.GotoCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Goto extends AbstractInstructionCommandHolder {

	public Goto() {
	}

	protected void registerCommand() {
		setCommand(new GotoCommand(ExecutionState.getMethodContext()));
	}

}
