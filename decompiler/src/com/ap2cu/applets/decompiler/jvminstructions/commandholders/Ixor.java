package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IxorCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Ixor extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IxorCommand(ExecutionState.getMethodContext()));
	}
}
