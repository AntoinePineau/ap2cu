package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Pop2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Pop2 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Pop2Command(ExecutionState.getMethodContext()));
	}
}
