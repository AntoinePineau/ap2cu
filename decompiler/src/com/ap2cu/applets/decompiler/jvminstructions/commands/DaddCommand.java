package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Constants;

public class DaddCommand extends AbstractInstructionCommand {

	public DaddCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
			OperandStack opStack = getStack();
	        Operand op= (Operand)opStack.pop();
	        Operand op1 = (Operand)opStack.pop();
	        Operand op2 = new Operand();
	        op2.setOperandValue("("+op1.getOperandValue()+")" +"+"+"("+op.getOperandValue()+")");
	        op2.setOperandType(Constants.IS_CONSTANT_DOUBLE);
	        boolean r=false;//checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
	        if(r){
	            if(opStack.size() > 0){
	                java.lang.String str=opStack.getTopOfStack().getOperandValue();
	                str=str+op2.getOperandValue();
	                op2.setOperandValue(str);
	            }
	        }
	        opStack.push(op2);
	}

}
