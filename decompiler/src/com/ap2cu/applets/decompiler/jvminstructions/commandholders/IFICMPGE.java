package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFICMPGECommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFICMPGE extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFICMPGECommand(ExecutionState.getMethodContext()));
	}
}

