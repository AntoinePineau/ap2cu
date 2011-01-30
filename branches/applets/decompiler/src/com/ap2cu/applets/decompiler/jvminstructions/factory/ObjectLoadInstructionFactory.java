package com.ap2cu.applets.decompiler.jvminstructions.factory;

import java.util.Map;

import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.AALoad;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.ALoad;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.AconstNull;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Aload_0;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Aload_1;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Aload_2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Aload_3;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Anewarray;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Arraylength;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.GetField;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.GetStatic;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IInstructionCommandHolder;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Multianewarray;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.New;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.NewArray;
import com.ap2cu.applets.decompiler.jvminstructions.utils.InstrConstants;


/*
 *  ObjectLoadInstructionFactory.java Copyright (c) 2006,07 Swaroop Belur
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
public class ObjectLoadInstructionFactory implements IInstructionFactory {

	public IInstructionCommandHolder newInstance(Map parameters) {

		Integer temp = (Integer) parameters.get(InstrConstants.OPCODE_TYPE);
		if (temp == null) {
			throw new IllegalArgumentException("Opcode type cannot be null");
		}

		int opcodevalue = temp.intValue();
		switch (opcodevalue) {
		case JvmOpCodes.AALOAD:
			return new AALoad();

		case JvmOpCodes.ACONST_NULL:
			return new AconstNull();

		case JvmOpCodes.ALOAD:
			return new ALoad();

		case JvmOpCodes.ALOAD_0:
			return new Aload_0();

		case JvmOpCodes.ALOAD_1:
			return new Aload_1();

		case JvmOpCodes.ALOAD_2:
			return new Aload_2();

		case JvmOpCodes.ALOAD_3:
			return new Aload_3();
			
		case JvmOpCodes.ANEWARRAY:
			return new Anewarray();
			
		case JvmOpCodes.ARRAYLENGTH:
			return new Arraylength();
			
		case JvmOpCodes.GETFIELD:
			return new GetField();
			
		case JvmOpCodes.GETSTATIC:
			return new GetStatic();
			
		case JvmOpCodes.MULTIANEWARRAY:
			return new Multianewarray();
			
		case JvmOpCodes.NEW:
			return new New();
		
		case JvmOpCodes.NEWARRAY:
			return new NewArray();

		default:
			throw new IllegalArgumentException(
					"Input argument opcodetype did not match any valid jvminstruction values");

		}

	}

}
