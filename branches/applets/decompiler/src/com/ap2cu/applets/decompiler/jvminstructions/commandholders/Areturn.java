package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.AReturnCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

/**
 * @author swaroop belur
 * @since 1.2.1
 */
public class Areturn extends AbstractInstructionCommandHolder{
    protected String getName() {
        return "AReturn";
    }

    protected void registerCommand() {
        AReturnCommand command = new AReturnCommand(ExecutionState.getMethodContext());
        setCommand(command);
    }
}
