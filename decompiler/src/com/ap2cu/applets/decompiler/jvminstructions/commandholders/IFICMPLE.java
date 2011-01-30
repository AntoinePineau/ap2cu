package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFICMPLECommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFICMPLE extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFICMPLECommand(ExecutionState.getMethodContext()));
	}
}
