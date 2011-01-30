package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.SastoreCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Sastore extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new SastoreCommand(ExecutionState.getMethodContext()));
	}
}
