package com.ap2cu.applets.decompiler.jvminstructions.commandholders;


import java.io.Serializable;

import com.ap2cu.applets.decompiler.jvminstructions.commands.IInstructionCommand;


public interface IInstructionCommandHolder extends Serializable {

    public IInstructionCommand getCommand();

    public void setCommand(IInstructionCommand command);

}
