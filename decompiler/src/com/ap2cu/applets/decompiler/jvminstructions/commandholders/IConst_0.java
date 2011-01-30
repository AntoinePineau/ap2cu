package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IConst_0Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IConst_0 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IConst_0Command(ExecutionState.getMethodContext()));
	}
}

