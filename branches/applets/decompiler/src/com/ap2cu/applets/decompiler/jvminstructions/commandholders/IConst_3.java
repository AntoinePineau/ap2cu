package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IConst_3Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IConst_3 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IConst_3Command(ExecutionState.getMethodContext()));
	}
}

