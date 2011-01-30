package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFNONNULLCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFNONNULL extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFNONNULLCommand(ExecutionState.getMethodContext()));
	}
}
