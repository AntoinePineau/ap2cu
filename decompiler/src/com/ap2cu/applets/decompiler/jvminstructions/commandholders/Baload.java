package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.BaloadCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Baload extends AbstractInstructionCommandHolder {

	public Baload() {
		
	}

	protected String getName() {
		
		return "Baload";
	}

	protected void registerCommand() {
		BaloadCommand command = new BaloadCommand(ExecutionState.getMethodContext());
		setCommand(command);
	}

}
