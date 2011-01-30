package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.InvokeStaticCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class InvokeStatic extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new InvokeStaticCommand(ExecutionState.getMethodContext()));
	}
}
