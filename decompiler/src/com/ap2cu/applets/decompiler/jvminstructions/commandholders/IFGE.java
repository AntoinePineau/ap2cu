package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFGECommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFGE extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFGECommand(ExecutionState.getMethodContext()));
	}
}
