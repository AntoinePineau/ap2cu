package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.JsrCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Jsr extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new JsrCommand(ExecutionState.getMethodContext()));
	}
}

