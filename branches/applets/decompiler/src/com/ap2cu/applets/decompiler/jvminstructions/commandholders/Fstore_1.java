package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Fstore_1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fstore_1 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fstore_1";
	}

	protected void registerCommand() {
		setCommand(new Fstore_1Command(ExecutionState.getMethodContext()));
	}

}
