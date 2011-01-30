package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Istore2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Istore2 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Istore2Command(ExecutionState.getMethodContext()));
	}
}
