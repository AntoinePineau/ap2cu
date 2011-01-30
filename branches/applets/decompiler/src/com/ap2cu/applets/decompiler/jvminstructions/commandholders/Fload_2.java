package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Fload_2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fload_2 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fload_2";
	}

	protected void registerCommand() {
		setCommand(new Fload_2Command(ExecutionState.getMethodContext()));
	}

}
