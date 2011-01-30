package com.ap2cu.applets.decompiler.jvminstructions.factory;

import java.util.Map;

import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IInstructionCommandHolder;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.InvokeInterface;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.InvokeSpecial;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.InvokeStatic;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.InvokeVirtual;
import com.ap2cu.applets.decompiler.jvminstructions.util.InstrConstants;


/*
 *  MethodInstructionFactory.java Copyright (c) 2006,07 Swaroop Belur
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
public class MethodInstructionFactory implements IInstructionFactory {

	public IInstructionCommandHolder newInstance(Map parameters) {
		Integer temp = (Integer) parameters.get(InstrConstants.OPCODE_TYPE);
		if (temp == null) {
			throw new IllegalArgumentException("Opcode type cannot be null");
		}

		int opcodevalue = temp.intValue();
		switch (opcodevalue) {
		
		case JvmOpCodes.INVOKEINTERFACE:
				return new InvokeInterface();
		
		case JvmOpCodes.INVOKESPECIAL:
				return new InvokeSpecial();
				
		case JvmOpCodes.INVOKESTATIC:
				return new InvokeStatic();
				
		case JvmOpCodes.INVOKEVIRTUAL:
				return new InvokeVirtual();
				
				
		default:
			throw new IllegalArgumentException(
					"Input argument opcodetype did not match any valid jvminstruction values");

		}

	}
}
