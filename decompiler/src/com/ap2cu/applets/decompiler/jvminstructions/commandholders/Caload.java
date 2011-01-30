package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.CaloadCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Caload extends AbstractInstructionCommandHolder {

	public Caload() {
	}

	protected String getName() {
		return "caload";
	}

	protected void registerCommand() {
		CaloadCommand command = new CaloadCommand(ExecutionState.getMethodContext());
		setCommand(command);
	}

}
