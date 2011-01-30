package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LcmpCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lcmp extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LcmpCommand(ExecutionState.getMethodContext()));
	}
}

