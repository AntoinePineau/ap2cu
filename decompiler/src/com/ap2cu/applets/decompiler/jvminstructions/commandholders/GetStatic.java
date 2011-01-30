package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.GetStaticCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class GetStatic extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "GetStatic";
	}

	protected void registerCommand() {
		setCommand(new GetStaticCommand(ExecutionState.getMethodContext()));
	}

}
