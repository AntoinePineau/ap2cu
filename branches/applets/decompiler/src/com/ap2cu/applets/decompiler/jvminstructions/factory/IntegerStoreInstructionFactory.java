package com.ap2cu.applets.decompiler.jvminstructions.factory;

import java.util.Map;

import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Bastore;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Castore;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IInstructionCommandHolder;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Iastore;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Istore;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Istore0;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Istore1;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Istore2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Istore3;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Sastore;
import com.ap2cu.applets.decompiler.jvminstructions.utils.InstrConstants;


/*
 *  IntegerStoreInstructionFactory.java Copyright (c) 2006,07 Swaroop Belur
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
public class IntegerStoreInstructionFactory implements IInstructionFactory {

	public IInstructionCommandHolder newInstance(Map parameters) {
		Integer temp = (Integer) parameters.get(InstrConstants.OPCODE_TYPE);
		if (temp == null) {
			throw new IllegalArgumentException("Opcode type cannot be null");
		}

		int opcodevalue = temp.intValue();
		switch (opcodevalue) {

		case JvmOpCodes.IASTORE:
			return new Iastore();
			
		case JvmOpCodes.ISTORE:
			return new Istore();	
			
		case JvmOpCodes.ISTORE_0:
			return new Istore0();
			
		case JvmOpCodes.ISTORE_1:
			return new Istore1();
			
		case JvmOpCodes.ISTORE_2:
			return new Istore2();
			
		case JvmOpCodes.ISTORE_3:
			return new Istore3();
			
		case JvmOpCodes.BASTORE:
			return new Bastore();
		
		case JvmOpCodes.CASTORE:
			return new Castore();

		case JvmOpCodes.SASTORE:
			return new Sastore();
			
		default:
			throw new IllegalArgumentException(
					"Input argument opcodetype did not match any valid jvminstruction values");
		}

	}
}
