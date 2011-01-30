package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.ReturnCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Return extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new ReturnCommand(ExecutionState.getMethodContext()));
	}
}
