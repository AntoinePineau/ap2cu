package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.InstanceOfCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class InstanceOf extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new InstanceOfCommand(ExecutionState.getMethodContext()));
	}
}

