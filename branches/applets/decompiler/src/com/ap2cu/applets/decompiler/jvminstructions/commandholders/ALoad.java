package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.ALoadCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

/**
 * @author swaroop belur
 * @since 1.2.1
 */
public class ALoad extends AbstractInstructionCommandHolder{

    protected String getName() {
        return "ALoad";
    }

    protected void registerCommand() {
        ALoadCommand command = new ALoadCommand(ExecutionState.getMethodContext());
        setCommand(command);
    }
}
