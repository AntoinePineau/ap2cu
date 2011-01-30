package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.DcmpgCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Dcmpg extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Dcmpg";
	}

	protected void registerCommand() {
		setCommand(new DcmpgCommand(ExecutionState.getMethodContext()));
	}

}
