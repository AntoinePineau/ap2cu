package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LaddCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class LADD extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LaddCommand(ExecutionState.getMethodContext()));
	}
}

