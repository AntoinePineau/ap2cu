package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IINCCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Iinc extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IINCCommand(ExecutionState.getMethodContext()));
	}
}

