package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Dload_2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class DLoad_2 extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "DLoad_2";
	}

	protected void registerCommand() {
		setCommand(new Dload_2Command(ExecutionState.getMethodContext()));
	}

}
