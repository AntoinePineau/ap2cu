package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Dload_3Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class DLoad_3 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "DLoad_3";
	}

	protected void registerCommand() {
		setCommand(new Dload_3Command(ExecutionState.getMethodContext()));
	}

}
