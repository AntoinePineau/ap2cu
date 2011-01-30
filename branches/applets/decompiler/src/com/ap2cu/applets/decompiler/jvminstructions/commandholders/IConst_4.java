package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IConst_4Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IConst_4 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IConst_4Command(ExecutionState.getMethodContext()));
	}
}

