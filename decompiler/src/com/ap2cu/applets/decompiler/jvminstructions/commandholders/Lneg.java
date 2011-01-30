package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LnegCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lneg extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LnegCommand(ExecutionState.getMethodContext()));
	}
}
