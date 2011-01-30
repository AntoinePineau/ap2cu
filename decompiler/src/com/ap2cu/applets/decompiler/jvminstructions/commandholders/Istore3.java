package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Istore3Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Istore3 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Istore3Command(ExecutionState.getMethodContext()));
	}
}
