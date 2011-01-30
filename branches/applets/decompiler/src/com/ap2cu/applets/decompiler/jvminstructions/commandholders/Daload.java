package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.DaloadCommad;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Daload extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Daload";
	}

	protected void registerCommand() {
		setCommand(new DaloadCommad(ExecutionState.getMethodContext()));
	}

}
