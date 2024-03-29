package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.D2FCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class D2F extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "d2f";
	}

	protected void registerCommand() {
		D2FCommand command = new D2FCommand(ExecutionState.getMethodContext());
		setCommand(command);
	}

}
