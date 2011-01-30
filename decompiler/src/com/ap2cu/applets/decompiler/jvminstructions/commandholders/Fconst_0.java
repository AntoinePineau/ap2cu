package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Fconst_0Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fconst_0 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fconst_0";
	}

	protected void registerCommand() {
		setCommand(new Fconst_0Command(ExecutionState.getMethodContext()));
	}

}
