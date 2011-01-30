package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Lstore_1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lstore_1 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Lstore_1Command(ExecutionState.getMethodContext()));
	}
}

