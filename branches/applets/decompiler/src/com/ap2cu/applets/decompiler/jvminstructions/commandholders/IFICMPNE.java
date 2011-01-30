package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFICMPNECommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFICMPNE extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFICMPNECommand(ExecutionState.getMethodContext()));
	}
}

