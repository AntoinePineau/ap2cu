package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.GOTO_WCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Goto_W extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new GOTO_WCommand(ExecutionState.getMethodContext()));
	}

}
