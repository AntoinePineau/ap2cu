package com.ap2cu.applets.decompiler.jvminstructions.commandholders;

import com.ap2cu.applets.decompiler.jvminstructions.commands.AbstractInstructionCommand;
import com.ap2cu.applets.decompiler.jvminstructions.commands.IInstructionCommand;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.ExecutionState;

public abstract class AbstractInstructionCommandHolder implements IInstructionCommandHolder {


    private IInstructionCommand command;



    public AbstractInstructionCommandHolder(){
        registerCommand();
    }

    public IInstructionCommand getCommand() {
        return command;
    }

    public void setCommand(IInstructionCommand command) {
        this.command = command;
    }

    public String toString() {
        StringBuffer string = new StringBuffer();
        string.append("[ "+ getName() + " -Instruction Code Pos : "+ ExecutionState.getCurrentInstructionPosition()+"]");
        string.append(System.getProperty("line.separator") + "[Method Name : "+((AbstractInstructionCommand)getCommand()).getContext().getBehaviourName()+"]");
        return string.toString();
    }
    
    public Behaviour getContext(){
    	return ExecutionState.getMethodContext();
    }

    protected String getName(){
    	return getClass().getName(); 
    }
    protected abstract void registerCommand();


    
}
