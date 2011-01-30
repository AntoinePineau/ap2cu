package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LushrCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lushr extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LushrCommand(ExecutionState.getMethodContext()));
	}
}