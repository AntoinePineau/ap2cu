package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IushrCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Iushr extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IushrCommand(ExecutionState.getMethodContext()));
	}
}
