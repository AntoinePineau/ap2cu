package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.GetfieldCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class GetField extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "GetField";
	}

	protected void registerCommand() {
		setCommand(new GetfieldCommand(ExecutionState.getMethodContext()));
	}

}
