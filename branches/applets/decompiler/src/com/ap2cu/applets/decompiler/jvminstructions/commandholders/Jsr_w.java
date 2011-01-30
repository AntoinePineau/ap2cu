package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Jsr_WCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Jsr_w extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Jsr_WCommand(ExecutionState.getMethodContext()));
	}
}

