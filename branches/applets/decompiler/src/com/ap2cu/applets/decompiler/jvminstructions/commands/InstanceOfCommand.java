package com.ap2cu.applets.decompiler.jvminstructions.commands;

import com.ap2cu.applets.decompiler.blockhelpers.IFHelper;
import com.ap2cu.applets.decompiler.config.Configuration;
import com.ap2cu.applets.decompiler.constantpool.ClassDescription;
import com.ap2cu.applets.decompiler.constantpool.ClassInfo;
import com.ap2cu.applets.decompiler.constantpool.NameAndType;
import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.core.ShortcutAnalyser;
import com.ap2cu.applets.decompiler.main.ConsoleLauncher;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Constants;

public class InstanceOfCommand extends AbstractInstructionCommand {

	public InstanceOfCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 2;
	}

	public void execute() {
		OperandStack opStack = getStack();
		Operand op = (Operand) opStack.pop();
		Operand op1 = new Operand();
		op1.setCategory(Constants.CATEGORY1);
		op1.setOperandType(Constants.IS_CONSTANT_STRING);
		int i = getCurrentInstPosInCode();
		int currentForIndex = getCurrentInstPosInCode();
		int classIndex = getGenericFinder().getOffset(i);
		i += 2;
		ClassDescription cd = getContext().getClassRef().getCd();
		ClassInfo constCInfo = cd.getClassInfoAtCPoolPosition(classIndex);
		NameAndType ninfo = cd.getNameAndTypeAtCPoolPosition(classIndex);
        String type = cd.getUTF8String(constCInfo.getUtf8pointer()).replace('/','.');
         if (Configuration.getShowImport().equals("true")) {
			java.lang.String fullName = type;
			java.lang.String simpleName = "";
			int lastdot = fullName.lastIndexOf(".");
			if (lastdot != -1) {
				simpleName = fullName.substring(lastdot + 1);
				type = simpleName;
				ConsoleLauncher.addImportClass(fullName);
			}
		}
        op1.setOperandValue(op.getOperandValue()
				+ " instanceof "
				+ type);
		byte[] info = getCode();
		ShortcutAnalyser sanalyser = getContext().getShortCutAnalyser();
		boolean sh = IFHelper.isIFShortcutORComp(info, (currentForIndex + 3));
		int j = currentForIndex + 3;
		boolean invert = sanalyser.isLastIfInChain(j);
        // TestCase: enumeration.java

        if (!invert) {
			java.lang.String connector = sanalyser.getConnector(j);
			if (connector != null
					&& connector.trim().equals(ShortcutAnalyser.AND)) {
				invert = true;
			}
		}


        if (!sh) {

            if (getGenericFinder().isThisInstrStart((currentForIndex + 3))) {
                if (getBranchFinder().isInstructionIF((currentForIndex + 3))){

                    int ifclose = IFHelper.getIfCloseNumberForThisIF(info,
                            (currentForIndex + 3));
                    ifclose = ifclose - 3;
                    if (getGenericFinder().isThisInstrStart(ifclose)) {
                        if (getBranchFinder().isInstructionIF(ifclose)
                                && ifclose != j) {
                            sh = true;
                        }
                    }
                }
            }
		}


        int firstIf = sanalyser.getFirstIfInChain(j);

        switch (info[(currentForIndex + 3)]) {
		case JvmOpCodes.IFEQ:
			if (!sh)
				op1.setOperandValue("(" + op1.getOperandValue() + ")!=false");
			else {
				if (!invert)
					op1.setOperandValue("(" + op1.getOperandValue()+ ")==false");
				else{
					  if(firstIf != j)
                    op1.setOperandValue("(" + op1.getOperandValue()
							+ ")==true");
                    else
                    op1.setOperandValue("(" + op1.getOperandValue()
							+ ")==false");
                }

            }
			break;
		case JvmOpCodes.IFNE:
			if (!sh)
				op1.setOperandValue("(" + op1.getOperandValue() + ")!=true");
			else {
				if (!invert)   {
                    if(firstIf == j)
                    op1.setOperandValue("(" + op1.getOperandValue()
							+ ")==false");
                    else
                    op1.setOperandValue("(" + op1.getOperandValue()
							+ ")==true");
                }
                else {
                    if(firstIf != j)
                    op1.setOperandValue("(" + op1.getOperandValue()
							+ ")==false");    //f
                    else
                    op1.setOperandValue("(" + op1.getOperandValue()
							+ ")==false");
                }
            }
			break;
		}

		boolean r = false;// checkIFLoadInstIsPartOFTernaryCond(currentForIndex);
		if (r) {
			if (opStack.size() > 0) {
				java.lang.String str = opStack.getTopOfStack()
						.getOperandValue();
				str = str + op1.getOperandValue();
				op1.setOperandValue(str);
			}
		}
		opStack.push(op1);

	}

}
