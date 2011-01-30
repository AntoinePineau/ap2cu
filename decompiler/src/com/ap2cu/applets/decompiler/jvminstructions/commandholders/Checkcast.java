package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.CheckcastCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Checkcast extends AbstractInstructionCommandHolder {


	protected void registerCommand() {
		CheckcastCommand command = new CheckcastCommand(ExecutionState.getMethodContext());
		setCommand(command);
	}

}
