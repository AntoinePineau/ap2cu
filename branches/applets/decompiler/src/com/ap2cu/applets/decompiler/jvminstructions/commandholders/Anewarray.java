package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.AnewarrayCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

/**
 * @author swaroop belur
 * @since 1.2.1
 */
public class Anewarray extends AbstractInstructionCommandHolder{

    protected String getName() {
        return "Anewarray";
    }

    protected void registerCommand() {
        AnewarrayCommand command = new AnewarrayCommand(ExecutionState.getMethodContext());
        setCommand(command);
    }
}
