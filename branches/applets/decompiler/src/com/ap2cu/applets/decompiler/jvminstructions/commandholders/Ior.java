package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IORCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Ior extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IORCommand(ExecutionState.getMethodContext()));
	}
}
