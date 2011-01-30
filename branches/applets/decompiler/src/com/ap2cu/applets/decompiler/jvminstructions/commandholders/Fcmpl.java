package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.FcmplCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class Fcmpl extends AbstractInstructionCommandHolder {

	protected String getName() {
		return "Fcmpl";
	}

	protected void registerCommand() {
		setCommand(new FcmplCommand(ExecutionState.getMethodContext()));
	}

}
