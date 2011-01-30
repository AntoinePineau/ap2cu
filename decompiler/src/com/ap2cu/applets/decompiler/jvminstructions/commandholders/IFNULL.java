package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFNULLCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFNULL extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFNULLCommand(ExecutionState.getMethodContext()));
	}
}
