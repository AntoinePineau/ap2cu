package com.ap2cu.applets.decompiler.jvminstructions.factory;

import java.util.Map;

import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.AAstore;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Astore;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Astore_0;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Astore_1;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Astore_2;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.Astore_3;
import com.ap2cu.applets.decompiler.jvminstructions.commandholders.IInstructionCommandHolder;
import com.ap2cu.applets.decompiler.jvminstructions.utils.InstrConstants;


/*
*  ObjectStoreInstructionFactory.java Copyright (c) 2006,07 Swaroop Belur
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
public class ObjectStoreInstructionFactory implements IInstructionFactory{

    public IInstructionCommandHolder newInstance(Map parameters) {
       

		Integer temp = (Integer) parameters.get(InstrConstants.OPCODE_TYPE);
		if (temp == null) {
			throw new IllegalArgumentException("Opcode type cannot be null");
		}

		int opcodevalue = temp.intValue();
		switch (opcodevalue) {
		case JvmOpCodes.AASTORE:
			return new AAstore();
			
		case JvmOpCodes.ASTORE:
			return new Astore();
			
		case JvmOpCodes.ASTORE_0:
			return new Astore_0();
			
		case JvmOpCodes.ASTORE_1:
			return new Astore_1();
			
		case JvmOpCodes.ASTORE_2:
			return new Astore_2();
			
		case JvmOpCodes.ASTORE_3:
			return new Astore_3();

		default:
			throw new IllegalArgumentException(
					"Input argument opcodetype did not match any valid jvminstruction values");

		}
    	
    }
}
