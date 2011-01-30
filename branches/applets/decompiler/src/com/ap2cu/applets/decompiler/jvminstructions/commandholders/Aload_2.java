package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Aload_2Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

/**
 * @author swaroop belur
 * @since 1.2.1
 */
public class Aload_2 extends AbstractInstructionCommandHolder{

    protected String getName() {
        return "Aload_2";
    }

    protected void registerCommand() {
        Aload_2Command command = new Aload_2Command(ExecutionState.getMethodContext());
        setCommand(command);
    }
}
