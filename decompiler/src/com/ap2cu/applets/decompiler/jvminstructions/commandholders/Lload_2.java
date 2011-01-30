package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Lload_2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lload_2 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Lload_2Command(ExecutionState.getMethodContext()));
	}
}

