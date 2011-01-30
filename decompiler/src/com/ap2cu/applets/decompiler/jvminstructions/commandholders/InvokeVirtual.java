package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.InvokeVirtualCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class InvokeVirtual extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new InvokeVirtualCommand(ExecutionState.getMethodContext()));
	}
}
