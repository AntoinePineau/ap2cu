package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.core.DecompilerHelper;
import com.ap2cu.applets.decompiler.core.LocalVariable;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Constants;

/**
 * @author swaroop belur
 * @since 1.2.1
 */
public class Aload_0Command extends AbstractInstructionCommand{

    public Aload_0Command(Behaviour context) {
        super(context);
    }

    public int getSkipBytes() {
        return 0;
    }

    public void execute() {
        OperandStack opStack = getContext().getOpStack();
        int currentForIndex= getCurrentInstPosInCode();
        LocalVariable local= DecompilerHelper.getLocalVariable(0,"load","java.lang.Object",true,currentForIndex);
        if(local==null) {
            local=new LocalVariable();
            local.setVarName("this");
        }


        Operand op = new Operand();
        op.setOperandName(local.getVarName());
        op.setOperandValue(local.getVarName());
        op.setOperandType(Constants.IS_OBJECT_REF);
        boolean r=false;//checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
        if(r){
            if(opStack.size() > 0){
                java.lang.String str=opStack.getTopOfStack().getOperandValue();
                str=str+op.getOperandValue();
                op.setOperandValue(str);
            }
        }

        opStack.push(op);
        op.setClassType(local.getDataType());
    }
}
