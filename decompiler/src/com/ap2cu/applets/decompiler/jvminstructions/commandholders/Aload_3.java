package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Aload_3Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

/**
 * @author swaroop belur
 * @since 1.2.1
 */
public class Aload_3 extends AbstractInstructionCommandHolder{

    protected String getName() {
        return "Aload_3";
    }

    protected void registerCommand() {
        Aload_3Command command = new Aload_3Command(ExecutionState.getMethodContext());
        setCommand(command);
    }
}
