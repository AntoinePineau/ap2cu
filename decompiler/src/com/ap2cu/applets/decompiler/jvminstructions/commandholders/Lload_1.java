package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Lload_1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lload_1 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Lload_1Command(ExecutionState.getMethodContext()));
	}
}

