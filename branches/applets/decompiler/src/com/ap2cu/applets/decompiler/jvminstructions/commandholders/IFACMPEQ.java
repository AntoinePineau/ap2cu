package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IFACMPEQCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class IFACMPEQ  extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new IFACMPEQCommand(ExecutionState.getMethodContext()));
	}
}
