package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LshlCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lshl extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LshlCommand(ExecutionState.getMethodContext()));
	}
}

