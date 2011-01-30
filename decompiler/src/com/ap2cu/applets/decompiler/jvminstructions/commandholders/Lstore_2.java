package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Lstore_2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lstore_2 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Lstore_2Command(ExecutionState.getMethodContext()));
	}
}

