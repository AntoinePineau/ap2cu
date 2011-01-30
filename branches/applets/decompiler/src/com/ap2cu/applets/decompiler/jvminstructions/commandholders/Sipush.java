package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.SipushCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Sipush extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new SipushCommand(ExecutionState.getMethodContext()));
	}
}

