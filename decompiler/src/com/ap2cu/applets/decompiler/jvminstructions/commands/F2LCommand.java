package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Constants;

public class F2LCommand extends AbstractInstructionCommand {

	public F2LCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack opStack = getStack();
        Operand  op =(Operand)opStack.pop();
        op.setOperandValue("(long)"+"("+op.getOperandValue()+")");
        op.setOperandType(Constants.IS_CONSTANT_LONG);
        boolean r=false;//checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
        if(r){
            if(opStack.size() > 0){
                java.lang.String str=opStack.getTopOfStack().getOperandValue();
                str=str+op.getOperandValue();
                op.setOperandValue(str);
            }
        }
        opStack.push(op);
	}

}
