package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.D2ICommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class D2I extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "D2I";
	}

	protected void registerCommand() {
		D2ICommand command = new D2ICommand(ExecutionState.getMethodContext());
		setCommand(command);
	}

}
