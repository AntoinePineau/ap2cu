package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IremCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Irem extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IremCommand(ExecutionState.getMethodContext()));
	}
}
