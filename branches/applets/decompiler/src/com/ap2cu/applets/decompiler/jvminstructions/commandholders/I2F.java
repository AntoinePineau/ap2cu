package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.I2FCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class I2F extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new I2FCommand(ExecutionState.getMethodContext()));
	}
}
