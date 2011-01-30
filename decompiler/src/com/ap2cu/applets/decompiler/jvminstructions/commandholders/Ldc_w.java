package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Ldc_wCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Ldc_w extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Ldc_wCommand(ExecutionState.getMethodContext()));
	}
}

