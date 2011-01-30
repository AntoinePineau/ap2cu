package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.InvokeInterfaceCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class InvokeInterface extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new InvokeInterfaceCommand(ExecutionState.getMethodContext()));
	}
}

