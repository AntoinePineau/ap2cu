package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.ArraylengthCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;

/**
 * @author swaroop belur
 * @since 1.2.1
 */
public class Arraylength extends AbstractInstructionCommandHolder{


    protected String getName() {
        return "Arraylength";
    }

    protected void registerCommand() {
          ArraylengthCommand command = new ArraylengthCommand(ExecutionState.getMethodContext());
          setCommand(command);         
    }
}
