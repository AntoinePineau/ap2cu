package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.PutfieldCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class PutField extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new PutfieldCommand(ExecutionState.getMethodContext()));
	}
}
