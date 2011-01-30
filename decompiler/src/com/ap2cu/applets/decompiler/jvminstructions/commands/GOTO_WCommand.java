package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class GOTO_WCommand extends AbstractInstructionCommand {

	public GOTO_WCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 4;
	}

	public void execute() {
		/***
		 * TODO : As of 1.2.1 unsupported Op in jdec.
		 */
	}

}
