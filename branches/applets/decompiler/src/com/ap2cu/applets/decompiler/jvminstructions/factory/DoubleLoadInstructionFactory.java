package com.ap2cu.applets.decompiler.jvminstructions.factory;

import java.util.Map;

import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.DConst_0;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.DConst_1;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.DLoad;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.DLoad_0;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.DLoad_1;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.DLoad_2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.DLoad_3;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dadd;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Daload;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dcmpg;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dcmpl;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Ddiv;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dmul;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dneg;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Drem;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dsub;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dup;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dup2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dup2x1;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dup2x2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dupx1;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Dupx2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.F2d;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IInstructionCommandHolder;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.L2d;
import com.ap2cu.applets.decompiler.jvminstructions.util.InstrConstants;


/*
 *  IntegerLoadInstructionFactory.java Copyright (c) 2006,07 Swaroop Belur
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
public class DoubleLoadInstructionFactory implements IInstructionFactory {

	public IInstructionCommandHolder newInstance(Map parameters) {
		Integer temp = (Integer) parameters.get(InstrConstants.OPCODE_TYPE);
		if (temp == null) {
			throw new IllegalArgumentException("Opcode type cannot be null");
		}

		int opcodevalue = temp.intValue();
		switch (opcodevalue) {
		
		
		case JvmOpCodes.DADD:
			return new Dadd();
			
		
		case JvmOpCodes.DALOAD:
			return new Daload();
			
		case JvmOpCodes.DCMPG:
			return new Dcmpg();
			
		case JvmOpCodes.DCMPL:
			return new Dcmpl();
			
		case JvmOpCodes.DCONST_0:
			return new DConst_0();
			
		case JvmOpCodes.DCONST_1:
			return new DConst_1();
			
		case JvmOpCodes.DDIV:
			return new Ddiv();
			
		case JvmOpCodes.DLOAD:
			return new DLoad();
			
		case JvmOpCodes.DLOAD_0:
			return new DLoad_0();
			
		case JvmOpCodes.DLOAD_1:
			return new DLoad_1();
			
		case JvmOpCodes.DLOAD_2:
			return new DLoad_2();
			
		case JvmOpCodes.DLOAD_3:
			return new DLoad_3();
			
			
		case JvmOpCodes.DMUL:
			return new Dmul();
			
		case JvmOpCodes.DNEG:
			return new Dneg();
			
		case JvmOpCodes.DREM:
			return new Drem();
			
		case JvmOpCodes.DSUB:
			return new Dsub();
			
	
			
			
		case JvmOpCodes.F2D:
			return new F2d();
			
		case JvmOpCodes.L2D:
			return new L2d();
			
		default:
			throw new IllegalArgumentException(
					"Input argument opcodetype did not match any valid jvminstruction values");

		}
	}
}
