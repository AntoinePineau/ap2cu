package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.MonitorExitCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class MonitorExit extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new MonitorExitCommand(ExecutionState.getMethodContext()));
	}
}

