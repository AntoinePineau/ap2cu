package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.PutstaticCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Putstatic extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new PutstaticCommand(ExecutionState.getMethodContext()));
	}
}

