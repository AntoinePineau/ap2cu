package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Dload_0Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class DLoad_0 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "DLoad_0";
	}

	protected void registerCommand() {
		setCommand(new Dload_0Command(ExecutionState.getMethodContext()));
	}

}
