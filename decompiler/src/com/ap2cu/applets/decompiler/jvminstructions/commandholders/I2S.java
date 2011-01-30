package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.I2SCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class I2S extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new I2SCommand(ExecutionState.getMethodContext()));
	}
}
