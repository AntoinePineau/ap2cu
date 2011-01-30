package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFICMPLTCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFICMPLT extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFICMPLTCommand(ExecutionState.getMethodContext()));
	}
}

