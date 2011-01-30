package com.ap2cu.applets.decompiler.jvminstructions.commands;


import java.util.ArrayList;
import java.util.Iterator;

import com.ap2cu.applets.decompiler.blockhelpers.BranchHelper;
import com.ap2cu.applets.decompiler.blockhelpers.IFHelper;
import com.ap2cu.applets.decompiler.blockhelpers.LoopHelper;
import com.ap2cu.applets.decompiler.blocks.IFBlock;
import com.ap2cu.applets.decompiler.blocks.Loop;
import com.ap2cu.applets.decompiler.core.GlobalVariableStore;
import com.ap2cu.applets.decompiler.core.JvmOpCodes;
import com.ap2cu.applets.decompiler.core.Operand;
import com.ap2cu.applets.decompiler.core.OperandStack;
import com.ap2cu.applets.decompiler.reflection.Behaviour;
import com.ap2cu.applets.decompiler.util.Util;

public class IFICMPEQCommand extends AbstractInstructionCommand {

	public IFICMPEQCommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 2;
	}

	public void execute() {
		int currentForIndex = getCurrentInstPosInCode();
		OperandStack opStack = getStack();
		int i = currentForIndex;
		byte[] info = getCode();
		Behaviour behavior = getContext();
		Loop thisLoop ;
		boolean encounteredAndOrComp = GlobalVariableStore
				.isEncounteredAndOrComp();
		boolean isIfInScope = GlobalVariableStore.isIfInScope();
		
		Operand op = (Operand) opStack.pop();
		Operand op1 = (Operand) opStack.pop();
		IFHelper.checkForBooleanOperandValue(op, op1);

		/*
		 * classIndex = ((i4 << 8) | i5); if(classIndex <
		 * 0)classIndex=(i4+1)*256-Math.abs(i5);
		 */
		int classIndex = getGenericFinder().getJumpAddress( i);
		i++;
		i++;

		
		ArrayList list = getContext().getBehaviourLoops();
		
		IFBlock ifst = new IFBlock();
		ifst.setIfStart(currentForIndex);
		ifst.setHasIfBeenGenerated(true);
		getContext().getMethodIfs().add(ifst);
		isIfInScope = true;
		BranchHelper.addBranchLabel(classIndex, i, ifst, currentForIndex, info);
		boolean addBreak = LoopHelper.checkForParentLoopForIF(ifst);
		// isEndOfLoop=isIndexEndOfLoop(list,(classIndex-3));
		boolean isEndOfLoop = LoopHelper.isIndexEndOfLoop(list, ifst
				.getIfCloseLineNumber());
		int loopstart = -1;
		boolean correctIf = false;
		String tempString="";
		boolean beyondLoop = LoopHelper.isBeyondLoop(ifst.getIfCloseLineNumber(), list,
				info);
        thisLoop=GlobalVariableStore.getThisLoop();
        boolean processIF = true;//checkForTernaryIf(ifst, info, op1.getOperandValue()				+ " != " + op.getOperandValue());
		if (processIF) {
			if (ifst.getDonotclose() == false
					&& ifst.getIfCloseLineNumber() == -1) {
				int if_end = IFHelper.checkIFEndIfUnset(ifst, info, currentForIndex);
				ifst.setIfCloseLineNumber(if_end);
			}
			if (isEndOfLoop) {
				loopstart = LoopHelper.getLoopStartForEnd(ifst.getIfCloseLineNumber(),
						list);
				if (currentForIndex > loopstart) {
					boolean ifinstcodepresent = IFHelper.getIfinst(loopstart, info,
							currentForIndex);
					if (ifinstcodepresent) {
						correctIf = false;
					} else
						correctIf = true;
				}
			}

			
			if ((ifst.getIfCloseLineNumber() > 0 && ifst.getIfCloseLineNumber() < info.length)
					&& info[ifst.getIfCloseLineNumber()] == JvmOpCodes.GOTO
					&& isEndOfLoop && correctIf)

			{
				int t = ifst.getIfCloseLineNumber();
				int gotoIndex = getGenericFinder().getJumpAddress( t);// (info[t+1] << 8) |
				// info[t+2]) +
				// (ifst.getIfCloseLineNumber());
				if (gotoIndex < (t + 3)) {
					boolean isInfiniteLoop = false;
					Iterator infLoop = getContext().getBehaviourLoops().iterator();
					while (infLoop.hasNext()) {
						Loop iloop = (Loop) infLoop.next();
						if (iloop.getStartIndex() == gotoIndex
								&& iloop.isInfinite()) {
							isInfiniteLoop = true;
							/*
							 * ifLevel++; ifst = new IFBlock();
							 * ifst.setIfStart(currentForIndex);
							 * ifst.setHasIfBeenGenerated(true);
							 */
							// ifst.setIfCloseLineNumber(classIndex-3);
							ifst.setElseCloseLineNumber(gotoIndex);
							// ifHashTable.put(""+(ifLevel),ifst);
							// isIfInScope=true;
							// addBranchLabel(classIndex,i,ifst,currentForIndex,info);
							boolean bb = LoopHelper.isBeyondLoop(getGenericFinder().getJumpAddress(
									currentForIndex), getContext()
									.getBehaviourLoops(), info);
                            thisLoop=GlobalVariableStore.getThisLoop();
                            isIfInScope = true;
							boolean print = true;
							boolean addifbreak = false;
							if (bb && thisLoop != null && thisLoop.isInfinite()
									&& !encounteredAndOrComp && addBreak) {
								Loop dowl = LoopHelper.isIfInADoWhile(currentForIndex,
										ifst, getContext().getBehaviourLoops());
								if (dowl != null) {
									tempString = "";
								} else {
									tempString = "\nif("
											+ op1.getOperandValue() + " == "
											+ op.getOperandValue()
											+ ")\n{\nbreak;\n}\n";
									// codeStatements
									// +=Util.formatDecompiledStatement(tempString);
									addifbreak = true;
								}
								print = false;
								// ifst.setIfHasBeenClosed(true);
							}
							boolean last = IFHelper.lastIFinShortCutChain(info, ifst,
									currentForIndex);
							boolean c = IFHelper.addCodeStatementWRTShortcutOR(ifst, op1
									.getOperandValue()
									+ " == " + op.getOperandValue(), print,
									"if", last, op1.getOperandValue() + " != "
											+ op.getOperandValue());
							if (c) {
								if (addifbreak) {
									behavior.appendToBuffer( Util
											.formatDecompiledStatement(tempString));
								}
								tempString = "\nif(" + op1.getOperandValue()
										+ " != " + op.getOperandValue()
										+ ")\n{\n";
								behavior.appendToBuffer( Util
										.formatDecompiledStatement(tempString));
							} else {
								boolean firstIfForLoop = LoopHelper.isIfFirstIfInLoopCondition(
										info, currentForIndex);
								if (firstIfForLoop) {
									IFHelper.registerElseBreakForIfChain(currentForIndex);
								}
							}
							
							break;
						}
					}
					if (isInfiniteLoop) {
						GlobalVariableStore.setEncounteredAndOrComp(encounteredAndOrComp);
						GlobalVariableStore.setIfInScope(isIfInScope);
						GlobalVariableStore.setThisLoop(thisLoop);
						
						return;
					}
					boolean last = IFHelper.lastIFinShortCutChain(info, ifst,
							currentForIndex);
					boolean c = IFHelper.addCodeStatementWRTShortcutOR(ifst, op1
							.getOperandValue()
							+ " == " + op.getOperandValue(), true, "while",
							last, op1.getOperandValue() + " != "
									+ op.getOperandValue());
					if (c) {
						tempString = "\nwhile(" + op1.getOperandValue() + "!= "
								+ op.getOperandValue() + ")\n{\n";
						behavior.appendToBuffer( Util
								.formatDecompiledStatement(tempString));
					} else {
						boolean firstIfForLoop = LoopHelper.isIfFirstIfInLoopCondition(
								info, currentForIndex);
						if (firstIfForLoop) {
							IFHelper.registerElseBreakForIfChain(currentForIndex);
						}
					}
				

				}
				// int x = 0;
				else {

					/*
					 * ifLevel++; ifst = new IFBlock();
					 * ifst.setIfStart(currentForIndex);
					 * ifst.setHasIfBeenGenerated(true); //
					 * ifst.setIfCloseLineNumber(classIndex-3);
					 */
					ifst.setElseCloseLineNumber(gotoIndex);
					// ifHashTable.put(""+(ifLevel),ifst);
					isIfInScope = true;
					// addBranchLabel(classIndex,i,ifst,currentForIndex,info);
					boolean bb = LoopHelper.isBeyondLoop(getGenericFinder().getJumpAddress(
							currentForIndex), getContext().getBehaviourLoops(),
							info);
                    thisLoop=GlobalVariableStore.getThisLoop();
                    boolean print = true;
					boolean addifbreak = false;
					if (bb && thisLoop != null && thisLoop.isInfinite()
							&& !encounteredAndOrComp && addBreak) {
						Loop dowl = LoopHelper.isIfInADoWhile(currentForIndex, ifst,
								getContext().getBehaviourLoops());
						if (dowl != null) {
							tempString = "";
						} else {
							tempString = "\nif(" + op1.getOperandValue()
									+ " == " + op.getOperandValue() + ")\n{\n"
									+ "break;\n" + "}\n";
							// codeStatements
							// +=Util.formatDecompiledStatement(tempString);
							addifbreak = true;
						}
						print = false;
						// ifst.setIfHasBeenClosed(true);
					}
					boolean last = IFHelper.lastIFinShortCutChain(info, ifst,
							currentForIndex);
					boolean c = IFHelper.addCodeStatementWRTShortcutOR(ifst, op1
							.getOperandValue()
							+ " == " + op.getOperandValue(), print, "if", last,
							op1.getOperandValue() + " != "
									+ op.getOperandValue());
					if (c) {
						if (addifbreak) {
							behavior.appendToBuffer( Util
									.formatDecompiledStatement(tempString));
						}
						tempString = "\nif(" + op1.getOperandValue() + " != "
								+ op.getOperandValue() + ")\n{\n";
						behavior.appendToBuffer( Util
								.formatDecompiledStatement(tempString));
					} else {
						boolean firstIfForLoop = LoopHelper.isIfFirstIfInLoopCondition(
								info, currentForIndex);
						if (firstIfForLoop) {
							IFHelper.registerElseBreakForIfChain(currentForIndex);
						}
					}
				

				}
			} else {
				/*
				 * ifLevel++; ifst = new IFBlock();
				 * ifst.setIfStart(currentForIndex);
				 * ifst.setHasIfBeenGenerated(true);
				 * ifHashTable.put(""+(ifLevel),ifst); isIfInScope=true;
				 * addBranchLabel(classIndex,i,ifst,currentForIndex,info);
				 */
				isIfInScope = true;
				boolean bb = LoopHelper.isBeyondLoop(
						getGenericFinder().getJumpAddress( currentForIndex), getContext()
								.getBehaviourLoops(), info);
				boolean print = true;
                thisLoop=GlobalVariableStore.getThisLoop();
                boolean addifbreak = false;
				if (bb && thisLoop != null && thisLoop.isInfinite()
						&& !encounteredAndOrComp && addBreak) {
					Loop dowl = LoopHelper.isIfInADoWhile(currentForIndex, ifst, getContext()
							.getBehaviourLoops());
					if (dowl != null) {
						tempString = "";
					} else {
						tempString = "\nif(" + op1.getOperandValue() + " == "
								+ op.getOperandValue() + ")\n{\n" + "break;\n"
								+ "}\n";
						// codeStatements
						// +=Util.formatDecompiledStatement(tempString);
					}
					print = false;
					// ifst.setIfHasBeenClosed(true);
				}
				boolean last = IFHelper.lastIFinShortCutChain(info, ifst,
						currentForIndex);
				boolean c = IFHelper.addCodeStatementWRTShortcutOR(ifst, op1
						.getOperandValue()
						+ " == " + op.getOperandValue(), print, "if", last, op1
						.getOperandValue()
						+ " != " + op.getOperandValue());
				if (c) {
					if (addifbreak) {
						behavior.appendToBuffer( Util
								.formatDecompiledStatement(tempString));
					}
					tempString = "\nif(" + op1.getOperandValue() + " != "
							+ op.getOperandValue() + ")\n{\n";
					behavior.appendToBuffer( Util
							.formatDecompiledStatement(tempString));
				} else {
					boolean firstIfForLoop = LoopHelper.isIfFirstIfInLoopCondition(info,
							currentForIndex);
					if (firstIfForLoop) {
						IFHelper.registerElseBreakForIfChain(currentForIndex);
					}
				}
				
			}
		}
		GlobalVariableStore.setEncounteredAndOrComp(encounteredAndOrComp);
		GlobalVariableStore.setIfInScope(isIfInScope);
		GlobalVariableStore.setThisLoop(thisLoop);
		

	}

}
