package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFGTCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFGT extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFGTCommand(ExecutionState.getMethodContext()));
	}
}

