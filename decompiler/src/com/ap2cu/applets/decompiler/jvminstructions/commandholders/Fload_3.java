package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Fload_3Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fload_3 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fload_3";
	}

	protected void registerCommand() {
		setCommand(new Fload_3Command(ExecutionState.getMethodContext()));
	}

}
