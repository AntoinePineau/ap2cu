package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class PopCommand extends AbstractInstructionCommand {

	public PopCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack opStack = getStack();
		if(opStack.size() > 0) // removed add==true
        {
                //if(info[i+1]!=JvmOpCodes.GETSTATIC)  ??
                opStack.getTopOfStack();
        }
	}

}
