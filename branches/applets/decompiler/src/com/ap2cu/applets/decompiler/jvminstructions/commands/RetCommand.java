package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class RetCommand extends AbstractInstructionCommand {

	public RetCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 1;
	}

	public void execute() {
	}

}
