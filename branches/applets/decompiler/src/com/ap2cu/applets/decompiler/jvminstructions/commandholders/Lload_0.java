package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Lload_0Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lload_0 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Lload_0Command(ExecutionState.getMethodContext()));
	}
}

