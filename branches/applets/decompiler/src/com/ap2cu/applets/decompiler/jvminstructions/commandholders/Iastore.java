package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IastoreCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Iastore extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IastoreCommand(ExecutionState.getMethodContext()));
	}
}
