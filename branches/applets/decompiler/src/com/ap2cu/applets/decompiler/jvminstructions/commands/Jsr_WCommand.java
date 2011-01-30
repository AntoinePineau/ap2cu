package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class Jsr_WCommand extends AbstractInstructionCommand {

	public Jsr_WCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 4;
	}

	public void execute() {
		/**
		 *  Leave empty
		 *  There is no need to handle this methods
		 *  as it is handled already by the
		 *  exception handler codes. 
		 *  
		 *  NOTE: Handled by try/finally handling code.
		 */
	}

}
