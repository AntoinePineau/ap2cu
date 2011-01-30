package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IConst_1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IConst_1 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IConst_1Command(ExecutionState.getMethodContext()));
	}
}

