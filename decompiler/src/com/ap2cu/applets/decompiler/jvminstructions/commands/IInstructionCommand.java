package com.ap2cu.applets.decompiler.jvminstructions.commands;

import java.io.Serializable;


public interface IInstructionCommand extends Serializable {

    public void execute();
}
