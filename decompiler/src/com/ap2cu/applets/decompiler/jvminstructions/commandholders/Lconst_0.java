package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Lconst_0Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Lconst_0 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Lconst_0Command(ExecutionState.getMethodContext()));
	}
}

