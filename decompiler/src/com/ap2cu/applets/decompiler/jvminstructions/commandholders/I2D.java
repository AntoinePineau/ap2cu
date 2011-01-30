package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.I2DCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class I2D extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new I2DCommand(ExecutionState.getMethodContext()));
	}
}
