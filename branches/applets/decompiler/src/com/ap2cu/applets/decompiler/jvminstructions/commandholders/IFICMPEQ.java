package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFICMPEQCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public  class IFICMPEQ extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFICMPEQCommand(ExecutionState.getMethodContext()));
	}
}

