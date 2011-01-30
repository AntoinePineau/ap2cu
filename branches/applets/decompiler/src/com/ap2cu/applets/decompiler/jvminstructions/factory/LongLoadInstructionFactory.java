package com.ap2cu.applets.decompiler.jvminstructions.factory;

import java.util.Map;

import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.D2L;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.F2L;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IInstructionCommandHolder;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.LADD;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Laload;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Land;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lcmp;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lconst_0;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lconst_1;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Ldc;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Ldc2_w;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Ldc_w;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Ldiv;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lload;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lload_0;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lload_1;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lload_2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lload_3;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lmul;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lneg;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lor;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lrem;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lshl;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lshr;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lsub;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lushr;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Lxor;
import com.ap2cu.applets.decompiler.jvminstructions.utils.InstrConstants;


/*
 *  LongLoadInstructionFactory.java Copyright (c) 2006,07 Swaroop Belur
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
public class LongLoadInstructionFactory implements IInstructionFactory {

	public IInstructionCommandHolder newInstance(Map parameters) {

		Integer temp = (Integer) parameters.get(InstrConstants.OPCODE_TYPE);
		if (temp == null) {
			throw new IllegalArgumentException("Opcode type cannot be null");
		}

		int opcodevalue = temp.intValue();
		switch (opcodevalue) {

		case JvmOpCodes.D2L:
			return new D2L();

		case JvmOpCodes.F2L:
			return new F2L();

		case JvmOpCodes.LADD:
			return new LADD();

		case JvmOpCodes.LALOAD:
			return new Laload();

		case JvmOpCodes.LAND:
			return new Land();

		case JvmOpCodes.LCMP:
			return new Lcmp();

		case JvmOpCodes.LCONST_0:
			return new Lconst_0();

		case JvmOpCodes.LCONST_1:
			return new Lconst_1();

		case JvmOpCodes.LDC:
			return new Ldc();

		case JvmOpCodes.LDC_W:
			return new Ldc_w();

		case JvmOpCodes.LDC2_W:
			return new Ldc2_w();

		case JvmOpCodes.LLOAD:
			return new Lload();

		case JvmOpCodes.LDIV:
			return new Ldiv();

		case JvmOpCodes.LLOAD_0:
			return new Lload_0();

		case JvmOpCodes.LLOAD_1:
			return new Lload_1();

		case JvmOpCodes.LLOAD_2:
			return new Lload_2();

		case JvmOpCodes.LLOAD_3:
			return new Lload_3();

		case JvmOpCodes.LMUL:
			return new Lmul();

		case JvmOpCodes.LNEG:
			return new Lneg();

		case JvmOpCodes.LREM:
			return new Lrem();

		case JvmOpCodes.LOR:
			return new Lor();

		case JvmOpCodes.LSHL:
			return new Lshl();

		case JvmOpCodes.LSHR:
			return new Lshr();

		case JvmOpCodes.LUSHR:
			return new Lushr();

		case JvmOpCodes.LSUB:
			return new Lsub();

		case JvmOpCodes.LXOR:
			return new Lxor();

		default:
			throw new IllegalArgumentException(
					"Input argument opcodetype did not match any valid jvminstruction values");

		}
	}
}
