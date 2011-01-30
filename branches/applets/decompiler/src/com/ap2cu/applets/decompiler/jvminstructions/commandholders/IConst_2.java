package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IConst_2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IConst_2 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IConst_2Command(ExecutionState.getMethodContext()));
	}
}
