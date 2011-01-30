package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IshlCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Ishl extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IshlCommand(ExecutionState.getMethodContext()));
	}
}
