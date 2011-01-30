package com.ap2cu.applets.decompiler.jvminstructions.commands;

import java.util.ArrayList;

import com.ap2cu.applets.decompiler.constantpool.ClassDescription;
import com.ap2cu.applets.decompiler.constantpool.FieldRef;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Util;


public class GetfieldCommand extends AbstractInstructionCommand {

	public GetfieldCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 2;
	}

	public void execute() {
		OperandStack opStack = getStack();
		Operand op = (Operand) opStack.pop();
		int currentForIndex = getCurrentInstPosInCode();
		int i = currentForIndex;

		int classIndex = getGenericFinder().getOffset(i);// (temp1 << 8) |
															// temp2);

		// if(classIndex < 0)classIndex=(temp1+1)*256-Math.abs(temp2);
		ClassDescription cd = getContext().getClassRef().getCd();
		FieldRef fref = cd.getFieldRefAtCPoolPosition(classIndex);
		// NameAndType ninfo=cd.getNameAndTypeAtCPoolPosition(classIndex);
		Operand op2 = new Operand();
		op2.setOperandValue(op.getOperandValue() + "." + fref.getFieldName());
		boolean r = false;// checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
		if (r) {
			if (opStack.size() > 0) {
				java.lang.String str = opStack.getTopOfStack()
						.getOperandValue();
				str = str + op2.getOperandValue();
				op2.setOperandValue(str);
			}
		}
		opStack.push(op2);
		Util.parseReturnType(fref.getTypeoffield());
		ArrayList returntype = Util.getreturnSignatureAsList();
		if (returntype.size() > 0)
			op2.setClassType((java.lang.String) returntype.get(0));
	}

}
