package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.AstoreCommand;
import com.ap2cu.applets.decompiler.util.ExecutionState;


public class Astore extends AbstractInstructionCommandHolder{

  protected String getName() {
    return "Astore";
  }

  protected void registerCommand() {
	  AstoreCommand command = new AstoreCommand(ExecutionState.getMethodContext());
	  setCommand(command);
  }
}