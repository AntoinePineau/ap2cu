package com.ap2cu.applets.decompiler.jvminstructions.factory;

import java.util.Map;

import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Areturn;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Athrow;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dreturn;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Freturn;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Goto;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Goto_W;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFACMPEQ;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFACMPNE;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFEQ;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFGE;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFGT;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFICMPEQ;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFICMPGE;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFICMPGT;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFICMPLE;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFICMPLT;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFICMPNE;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFLE;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFLT;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFNE;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFNONNULL;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IFNULL;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IInstructionCommandHolder;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Ireturn;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Jsr;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Jsr_w;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.LookupSwitch;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lreturn;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.MonitorEnter;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.MonitorExit;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Ret;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Return;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.TableSwitch;
import com.ap2cu.applets.decompiler.jvminstructions.util.InstrConstants;


public class BranchInstructionFactory implements IInstructionFactory {

	public BranchInstructionFactory() {
	}

	public IInstructionCommandHolder newInstance(Map parameters) {

		Integer temp = (Integer) parameters.get(InstrConstants.OPCODE_TYPE);
		if (temp == null) {
			throw new IllegalArgumentException("Opcode type cannot be null");
		}

		int opcodevalue = temp.intValue();
		switch (opcodevalue) {
		case JvmOpCodes.IF_ACMPEQ:
				return new IFACMPEQ();
				
		case JvmOpCodes.IF_ACMPNE:
			return new IFACMPNE();
			
		case JvmOpCodes.IF_ICMPEQ:
			return new IFICMPEQ();
			
		case JvmOpCodes.IF_ICMPGE:
			return new IFICMPGE();
		
		case JvmOpCodes.IF_ICMPGT:
			return new IFICMPGT();
			
		case JvmOpCodes.IF_ICMPLE:
			return new IFICMPLE();
	
		case JvmOpCodes.IF_ICMPLT:
			return new IFICMPLT();
			
		case JvmOpCodes.IF_ICMPNE:
			return new IFICMPNE();
		
		case JvmOpCodes.IFEQ:
			return new IFEQ();
			

		case JvmOpCodes.IFNE:
			return new IFNE();

		case JvmOpCodes.IFLT:
			return new IFLT();
			
		case JvmOpCodes.IFGT:
			return new IFGT();
			
		case JvmOpCodes.IFGE:
			return new IFGE();
			
		case JvmOpCodes.IFLE:
			return new IFLE();
			
		case JvmOpCodes.IFNONNULL:
			return new IFNONNULL();	
		
		case JvmOpCodes.IFNULL:
			return new IFNULL();
			
		case JvmOpCodes.IRETURN:
			return new Ireturn();	
			
		case JvmOpCodes.ARETURN:
			return new Areturn();
			
		case JvmOpCodes.ATHROW:
			return new Athrow();
			
		case JvmOpCodes.DRETURN:
			return new Dreturn();
			
		case JvmOpCodes.FRETURN:
			return new Freturn();
			
		case JvmOpCodes.GOTO:
			return new Goto();
			
		case JvmOpCodes.GOTO_W:
			return new Goto_W();
			
		case JvmOpCodes.JSR:
			return new Jsr();
		
		case JvmOpCodes.JSR_W:
			return new Jsr_w();
		
		case JvmOpCodes.MONITORENTER:
			return new MonitorEnter();
			
		case JvmOpCodes.MONITOREXIT:
			return new MonitorExit();
			
		case JvmOpCodes.RET:
			return new Ret();
			
		case JvmOpCodes.RETURN:
			return new Return();
			
		case JvmOpCodes.TABLESWITCH:
			return new TableSwitch();
			
		case JvmOpCodes.LOOKUPSWITCH:
			return new LookupSwitch();
			
		case JvmOpCodes.LRETURN:
			return new Lreturn();
			
		default:
			throw new IllegalArgumentException(
					"Input argument opcodetype did not match any valid jvminstruction values");
		}
	}

}
