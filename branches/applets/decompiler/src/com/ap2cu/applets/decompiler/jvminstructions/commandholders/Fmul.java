package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FmulCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fmul extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fmul";
	}

	protected void registerCommand() {
		setCommand(new FmulCommand(ExecutionState.getMethodContext()));
	}

}
