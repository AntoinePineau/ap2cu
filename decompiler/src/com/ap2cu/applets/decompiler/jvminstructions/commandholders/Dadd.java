package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.DaddCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Dadd extends AbstractInstructionCommandHolder {

	protected String getName() {
		return null;
	}

	protected void registerCommand() {
		DaddCommand command = new DaddCommand(ExecutionState.getMethodContext());
		setCommand(command);
	}


}
