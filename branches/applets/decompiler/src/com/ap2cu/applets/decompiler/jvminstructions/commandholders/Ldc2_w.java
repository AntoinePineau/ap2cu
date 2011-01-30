package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Ldc2_wCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Ldc2_w extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Ldc2_wCommand(ExecutionState.getMethodContext()));
	}
}

