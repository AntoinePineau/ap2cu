package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Fload_0Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fload_0 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fload_0";
	}

	protected void registerCommand() {
		setCommand(new Fload_0Command(ExecutionState.getMethodContext()));
	}

}
