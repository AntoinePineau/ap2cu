package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.LstoreCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lstore extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new LstoreCommand(ExecutionState.getMethodContext()));
	}
}

