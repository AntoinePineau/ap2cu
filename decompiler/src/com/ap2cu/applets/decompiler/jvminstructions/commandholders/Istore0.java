package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Istore0Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Istore0 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Istore0Command(ExecutionState.getMethodContext()));
	}
}
