package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class Pop2Command extends AbstractInstructionCommand{

	

	public Pop2Command(Behaviour context) {
		super(context);
		
	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack opStack = getStack();
		 if(opStack.size() >= 3){
             opStack.getTopOfStack();
             opStack.getTopOfStack();
             opStack.getTopOfStack();
         }
	}

}
