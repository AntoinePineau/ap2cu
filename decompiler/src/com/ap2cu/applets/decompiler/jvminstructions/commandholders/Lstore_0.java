package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Lstore_0Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lstore_0 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Lstore_0Command(ExecutionState.getMethodContext()));
	}
}

