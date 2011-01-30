package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Aload_0Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

/**
 * @author swaroop belur
 * @since 1.2.1
 */
public class Aload_0 extends AbstractInstructionCommandHolder{

    protected String getName() {
        return "Aload_0";
    }

    protected void registerCommand() {
        Aload_0Command command = new Aload_0Command(ExecutionState.getMethodContext());
        setCommand(command);
    }
}
