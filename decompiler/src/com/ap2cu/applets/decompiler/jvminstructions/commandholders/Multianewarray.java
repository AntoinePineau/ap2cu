package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.MultiAnewArrayCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Multianewarray extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new MultiAnewArrayCommand(ExecutionState.getMethodContext()));
	}
}
