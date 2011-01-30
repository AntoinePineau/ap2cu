package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FcmpgCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fcmpg extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fcmpg";
	}

	protected void registerCommand() {
		setCommand(new FcmpgCommand(ExecutionState.getMethodContext()));
	}

}
