package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IConst_5Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IConst_5 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IConst_5Command(ExecutionState.getMethodContext()));
	}
}

