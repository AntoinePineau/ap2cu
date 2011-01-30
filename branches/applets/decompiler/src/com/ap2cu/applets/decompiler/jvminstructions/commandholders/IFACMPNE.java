package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFACMPNECommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFACMPNE extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFACMPNECommand(ExecutionState.getMethodContext()));
	}
}
