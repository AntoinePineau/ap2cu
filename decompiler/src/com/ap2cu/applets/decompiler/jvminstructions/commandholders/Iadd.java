package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IaddCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Iadd extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IaddCommand(ExecutionState.getMethodContext()));
	}
}
