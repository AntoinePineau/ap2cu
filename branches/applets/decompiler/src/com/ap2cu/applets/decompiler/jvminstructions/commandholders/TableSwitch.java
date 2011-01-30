package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.TableSwitchCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public class TableSwitch extends AbstractInstructionCommandHolder {

	protected void registerCommand() {
		setCommand(new TableSwitchCommand(ExecutionState.getMethodContext()));
	}
}

