package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Lconst_1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lconst_1 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Lconst_1Command(ExecutionState.getMethodContext()));
	}
}

