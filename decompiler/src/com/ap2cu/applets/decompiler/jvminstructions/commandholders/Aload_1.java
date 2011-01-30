package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.Aload_1Command;
import com.ap2cu.applets.decompiler.util.ExecutionState;

/**
 * @author swaroop belur
 * @since 1.2.1
 */
public class Aload_1 extends AbstractInstructionCommandHolder{

    protected String getName() {
        return "Aload_1";
    }

    protected void registerCommand() {
        Aload_1Command command = new Aload_1Command(ExecutionState.getMethodContext());
        setCommand(command);
    }
}
