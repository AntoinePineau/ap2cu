package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFLECommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFLE extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFLECommand(ExecutionState.getMethodContext()));
	}
}
