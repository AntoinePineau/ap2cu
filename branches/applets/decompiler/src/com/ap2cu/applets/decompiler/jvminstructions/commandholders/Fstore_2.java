package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Fstore_2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fstore_2 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fstore_2";
	}

	protected void registerCommand() {
		setCommand(new Fstore_2Command(ExecutionState.getMethodContext()));
	}

}
