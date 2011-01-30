package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Fstore_0Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fstore_0 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fstore_0";
	}

	protected void registerCommand() {
		setCommand(new Fstore_0Command(ExecutionState.getMethodContext()));
	}

}
