package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.DloadCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class DLoad extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "DLoad";
	}

	protected void registerCommand() {
		setCommand(new DloadCommand(ExecutionState.getMethodContext()));
	}

}
