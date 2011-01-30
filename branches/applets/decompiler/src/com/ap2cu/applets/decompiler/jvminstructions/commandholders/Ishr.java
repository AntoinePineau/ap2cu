package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IshrCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Ishr extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IshrCommand(ExecutionState.getMethodContext()));
	}
}
