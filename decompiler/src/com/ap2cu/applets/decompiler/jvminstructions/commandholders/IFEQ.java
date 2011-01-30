package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFEQCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFEQ extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFEQCommand(ExecutionState.getMethodContext()));
	}
}
