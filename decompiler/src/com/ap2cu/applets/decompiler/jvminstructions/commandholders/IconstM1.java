package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IConstM1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IconstM1 extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IConstM1Command(ExecutionState.getMethodContext()));
	}
}
