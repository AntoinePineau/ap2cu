package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;

public class L2fCommand extends AbstractInstructionCommand {

	public L2fCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		OperandStack opStack = getStack();
		Operand operand=opStack.getTopOfStack();
        operand.setOperandValue("(float)"+"("+operand.getOperandValue()+")");
        
        boolean r=false;//checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
        if(r){
            if(opStack.size() > 0){
                java.lang.String str=opStack.getTopOfStack().getOperandValue();
                str=str+operand.getOperandValue();
                operand.setOperandValue(str);
            }
        }
        opStack.push(operand);
	}

}
