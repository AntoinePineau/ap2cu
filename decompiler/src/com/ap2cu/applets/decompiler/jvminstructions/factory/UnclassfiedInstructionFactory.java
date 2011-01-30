package com.ap2cu.applets.decompiler.jvminstructions.factory;

import java.util.Map;

import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dup;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dup2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dup2x1;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dup2x2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dupx1;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dupx2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IInstructionCommandHolder;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Nop;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Pop;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Pop2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.PutField;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Putstatic;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Swap;
import com.ap2cu.applets.decompiler.jvminstructions.util.InstrConstants;

/*
*  UnclassfiedInstructionFactory.java Copyright (c) 2006,07 Swaroop Belur
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
 
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
 
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*
*/
public class UnclassfiedInstructionFactory implements IInstructionFactory {

	public IInstructionCommandHolder newInstance(Map parameters) {
		Integer temp = (Integer) parameters.get(InstrConstants.OPCODE_TYPE);
		if (temp == null) {
			throw new IllegalArgumentException("Opcode type cannot be null");
		}

		int opcodevalue = temp.intValue();
		switch (opcodevalue) {
		
		case JvmOpCodes.NOP:
			return new Nop();
			
		case JvmOpCodes.POP:
			return new Pop();
			
		case JvmOpCodes.POP2:
			return new Pop2();
			
		case JvmOpCodes.PUTFIELD:
			return new PutField();
			
		case JvmOpCodes.PUTSTATIC:
			return new Putstatic();
		
		case  JvmOpCodes.SWAP:
			return new Swap();
			
		case JvmOpCodes.DUP:
			return new Dup(); 
			
		case JvmOpCodes.DUP_X1:
			return new Dupx1();
			
		case JvmOpCodes.DUP_X2:
			return new Dupx2();
			
		case JvmOpCodes.DUP2_X1:
			return new Dup2x1();	
			
			
		case JvmOpCodes.DUP2:
			return new Dup2(); 
			
		case JvmOpCodes.DUP2_X2:
			return new Dup2x2();	
				
		
		default:
			throw new IllegalArgumentException(
					"Input argument opcodetype did not match any valid jvminstruction values");
		}
	}

}

