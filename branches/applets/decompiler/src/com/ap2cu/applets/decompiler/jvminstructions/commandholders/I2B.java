package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.I2BCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class I2B extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new I2BCommand(ExecutionState.getMethodContext()));
	}

}
