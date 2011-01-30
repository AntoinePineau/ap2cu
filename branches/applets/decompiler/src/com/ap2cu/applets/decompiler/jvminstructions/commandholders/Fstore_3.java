package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Fstore_3Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fstore_3 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fstore_3";
	}

	protected void registerCommand() {
		setCommand(new Fstore_3Command(ExecutionState.getMethodContext()));
	}

}
