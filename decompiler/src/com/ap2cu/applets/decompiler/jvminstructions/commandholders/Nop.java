package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.NopCommand;

public class Nop extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new NopCommand());
	}
}

