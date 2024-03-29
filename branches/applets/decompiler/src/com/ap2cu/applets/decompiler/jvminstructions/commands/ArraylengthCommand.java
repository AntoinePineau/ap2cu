package com.ap2cu.applets.decompiler.jvminstructions.commands;


import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Util;

/*
 *  ArraylengthCommand.java Copyright (c) 2006,07 Swaroop Belur
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

/**
 * @author swaroop belur
 * @since 1.2.1
 */
public class ArraylengthCommand extends AbstractInstructionCommand {
	public ArraylengthCommand(Behaviour context) {
		super(context);
	}

	public int getSkipBytes() {
		return 0;
	}

	public void execute() {
		boolean oktoadd = true;
		OperandStack opStack = getStack();
		Operand op = (Operand) opStack.pop();
		Operand tempOperand = op;
		op = new Operand();
		op.setOperandValue(tempOperand.getOperandValue() + ".length");
		boolean r = false;// checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
		if (r) {
			if (opStack.size() > 0) {
				java.lang.String str = opStack.getTopOfStack()
						.getOperandValue();
				str = str + op.getOperandValue();
				op.setOperandValue(str);
			}
		}
		opStack.push(op);
	}
}
