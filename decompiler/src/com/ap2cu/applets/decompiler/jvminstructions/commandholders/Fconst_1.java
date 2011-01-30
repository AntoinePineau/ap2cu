package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Fconst_1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fconst_1 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fconst_1";
	}

	protected void registerCommand() {
		setCommand(new Fconst_1Command(ExecutionState.getMethodContext()));
	}

}
