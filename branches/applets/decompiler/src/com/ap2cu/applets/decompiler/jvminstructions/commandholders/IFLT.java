package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFLTCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFLT extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFLTCommand(ExecutionState.getMethodContext()));
	}
}
