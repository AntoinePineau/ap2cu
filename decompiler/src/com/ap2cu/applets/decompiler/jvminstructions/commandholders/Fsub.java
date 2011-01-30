package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FsubCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fsub extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fsub";
	}

	protected void registerCommand() {
		setCommand(new FsubCommand(ExecutionState.getMethodContext()));
	}

}
