package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Istore1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Istore1 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new Istore1Command(ExecutionState.getMethodContext()));
	}
}
