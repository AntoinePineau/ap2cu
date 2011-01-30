package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Lstore_3Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lstore_3 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Lstore_3Command(ExecutionState.getMethodContext()));
	}
}

