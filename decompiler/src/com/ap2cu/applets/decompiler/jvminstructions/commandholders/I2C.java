package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.I2CCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class I2C extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new I2CCommand(ExecutionState.getMethodContext()));
	}
}
