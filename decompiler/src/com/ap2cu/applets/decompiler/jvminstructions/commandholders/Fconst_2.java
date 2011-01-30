package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Fconst_2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fconst_2 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fconst_2";
	}

	protected void registerCommand() {
		setCommand(new Fconst_2Command(ExecutionState.getMethodContext()));
	}

}
