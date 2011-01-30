package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IReturnCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Ireturn extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IReturnCommand(ExecutionState.getMethodContext()));
	}
}

