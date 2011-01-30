package com.ap2cu.applets.decompiler.jvminstructions.commands;

import java.util.Iterator;
import java.util.Map;

import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Util;


public class LreturnCommand extends AbstractInstructionCommand {

	public LreturnCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		 Map returnsAtI = GlobalVariableStore.getReturnsAtI();
		 int i = getCurrentInstPosInCode();
		 boolean oktoadd=true;
         Iterator  mapIT=returnsAtI.entrySet().iterator();
         while(mapIT.hasNext()) {
             Map.Entry entry=(Map.Entry)mapIT.next();
             Object key=entry.getKey();
             Object retStatus=entry.getValue().toString();
             if(key instanceof Integer) {
                 Integer pos=(Integer)key;
                 int temp=pos.intValue();
                 if(temp==i) {
                     if(retStatus.equals("true")) {
                         
                         oktoadd=false;
                         break;
                     }
                 }
             }
             
         }
         
         
         if(!oktoadd) {
             returnsAtI.remove(new Integer(i));
         }
         OperandStack opStack = getStack();
         if(oktoadd && opStack.size() > 0){
             Operand op = opStack.getTopOfStack();
             String tempString="return "+op.getOperandValue().toString()+";\n";
             Behaviour behavior = getContext();
             behavior.appendToBuffer(Util.formatDecompiledStatement(tempString));
             
         }
         
         
	}

}
