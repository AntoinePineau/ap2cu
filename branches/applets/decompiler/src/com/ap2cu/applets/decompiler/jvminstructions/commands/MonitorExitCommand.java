package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class MonitorExitCommand extends AbstractInstructionCommand {

	public MonitorExitCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		byte[] info = getCode();
		int i = getCurrentInstPosInCode();
		if (info[i + 1] != JvmOpCodes.ATHROW)
			getStack().getTopOfStack();
	}

}
