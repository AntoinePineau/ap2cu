package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Fload_1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fload_1 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fload_1";
	}

	protected void registerCommand() {
		setCommand(new Fload_1Command(ExecutionState.getMethodContext()));
	}

}
