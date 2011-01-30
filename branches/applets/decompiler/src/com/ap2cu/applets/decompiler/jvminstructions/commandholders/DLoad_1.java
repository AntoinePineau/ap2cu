package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Dload_1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class DLoad_1 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "DLoad_1";
	}

	protected void registerCommand() {
		setCommand(new Dload_1Command(ExecutionState.getMethodContext()));
	}

}
