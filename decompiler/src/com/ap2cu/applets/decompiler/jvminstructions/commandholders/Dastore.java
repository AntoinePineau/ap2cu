package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.DastoreCommand;

public class Dastore extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Dastore";
	}

	protected void registerCommand() {
		setCommand(new DastoreCommand(getContext()));
	}

}
