package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.I2LCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class I2L extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new I2LCommand(ExecutionState.getMethodContext()));
	}
}