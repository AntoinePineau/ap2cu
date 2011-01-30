package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFNECommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFNE extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFNECommand(ExecutionState.getMethodContext()));
	}
}
