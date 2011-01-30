package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFICMPGTCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFICMPGT extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFICMPGTCommand(ExecutionState.getMethodContext()));
	}
}
