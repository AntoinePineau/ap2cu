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

public class IFLECommand extends AbstractInstructionCommand {

	public IFLECommand(Behaviour context) {
		super(context);

	}

	public int getSkipBytes() {
		return 2;
	}

	public void execute() {
		String tempString = "";
		String tempstr = "";
		byte[] info = getCode();
		int currentForIndex = getCurrentInstPosInCode();
		int prevStart = getGenericFinder().getPrevStartOfInst(currentForIndex);
		OperandStack opStack = getStack();
		Behaviour behavior = getContext();

		Loop thisLoop ;
		boolean encounteredAndOrComp = GlobalVariableStore
				.isEncounteredAndOrComp();
		boolean isIfInScope = GlobalVariableStore.isIfInScope();
		Operand op = (Operand) opStack.pop();

		// op1 = (Operand)opStack.pop();
		int i = currentForIndex;
	
		int classIndex = getGenericFinder().getJumpAddress(i);
		i += 2;

		// int s=info[classIndex-3];
		ArrayList list = getContext().getBehaviourLoops();

		IFBlock ifst = new IFBlock();
		ifst.setIfStart(currentForIndex);
		ifst.setHasIfBeenGenerated(true);
		getContext().getMethodIfs().add(ifst);
		boolean addBreak = LoopHelper.checkForParentLoopForIF(ifst);
		BranchHelper.addBranchLabel(classIndex, i, ifst, currentForIndex, info);

		boolean isEndOfLoop = LoopHelper.isIndexEndOfLoop(list, ifst
				.getIfCloseLineNumber());
		boolean beyondLoop = LoopHelper.isBeyondLoop(ifst
				.getIfCloseLineNumber(), list, info);
        thisLoop = GlobalVariableStore.getThisLoop()         ;
        boolean correctIf = false;
		if (info[currentForIndex - 1] != JvmOpCodes.DCMPG
				&& info[currentForIndex - 1] != JvmOpCodes.DCMPL
				&& info[currentForIndex - 1] != JvmOpCodes.FCMPG
				&& info[currentForIndex - 1] != JvmOpCodes.FCMPL
				&& info[currentForIndex - 1] != JvmOpCodes.LCMP) {

			tempstr = op.getOperandValue() + " <= 0";
		} else {

			tempstr = op.getOperandValue();
		}
		boolean processIF = true;// checkForTernaryIf(ifst, info, tempstr);
		if (processIF) {
			if (ifst.getDonotclose() == false
					&& ifst.getIfCloseLineNumber() == -1) {
				int if_end = IFHelper.checkIFEndIfUnset(ifst, info,
						currentForIndex);
				ifst.setIfCloseLineNumber(if_end);
			}
			if (isEndOfLoop) {
				int loopstart = LoopHelper.getLoopStartForEnd(ifst
						.getIfCloseLineNumber(), list);
				if (currentForIndex > loopstart) {
					boolean ifinstcodepresent = IFHelper.getIfinst(loopstart,
							info, currentForIndex);
					if (ifinstcodepresent) {
						correctIf = false;
					} else
						correctIf = true;
				} else {
					correctIf = false;
				}

			}

			/*
			 * if(ifst.getIfStart()==ifst.getIfCloseLineNumber()){
			 * ifst.setIfCloseLineNumber(-1); ifst.setDonotclose(true);
			 * continue; } if(ifst.getIfStart()+3==ifst.getIfCloseLineNumber()){
			 * ifst.setIfCloseLineNumber(-1); ifst.setDonotclose(true);
			 * continue; }
			 */

			if ((ifst.getIfCloseLineNumber() > 0 && ifst.getIfCloseLineNumber() < info.length)
					&& info[ifst.getIfCloseLineNumber()] == JvmOpCodes.GOTO
					&& isEndOfLoop && correctIf) {
				int t = ifst.getIfCloseLineNumber();
				int gotoIndex = getGenericFinder().getJumpAddress(t);// ((info[t+1]
																		// << 8)
																		// |
				// info[t+2]) +
				// (ifst.getIfCloseLineNumber());
				if (gotoIndex < (t + 3))
					if (gotoIndex < classIndex) {
						boolean isInfiniteLoop = false;
						Iterator infLoop = getContext().getBehaviourLoops()
								.iterator();
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

								ifst.setElseCloseLineNumber(gotoIndex);

								/*
								 * ifHashTable.put(""+(ifLevel),ifst); int
								 * resetVal=checkIfElseCloseNumber(classIndex-3,ifst);
								 * ifst.setIfCloseLineNumber(resetVal);
								 */

								isIfInScope = true;

								boolean bb = LoopHelper.isBeyondLoop(
										getGenericFinder().getJumpAddress(
												currentForIndex), getContext()
												.getBehaviourLoops(), info);
                                thisLoop = GlobalVariableStore.getThisLoop();
                                boolean print = true;
								boolean addifbreak = false;
								java.lang.String tempString2 = "";
								if (bb && thisLoop != null
										&& thisLoop.isInfinite()
										&& !encounteredAndOrComp && addBreak) {
									Loop dowl = LoopHelper.isIfInADoWhile(
											currentForIndex, ifst, getContext()
													.getBehaviourLoops());
									if (dowl != null) {
										tempString = "";
									} else {
										if (info[currentForIndex - 1] != JvmOpCodes.DCMPG
												&& info[currentForIndex - 1] != JvmOpCodes.DCMPL
												&& info[currentForIndex - 1] != JvmOpCodes.FCMPG
												&& info[currentForIndex - 1] != JvmOpCodes.FCMPL
												&& info[currentForIndex - 1] != JvmOpCodes.LCMP)
											tempString = "\nif("
													+ op.getOperandValue()
													+ "<=0)\n{\nbreak;\n}\n";

										else
											tempString = "\nif("
													+ op.getOperandValue()
													+ ")\n{\nbreak;\n}\n";
										// codeStatements
										// +=Util.formatDecompiledStatement(tempString);
										addifbreak = true;
										tempString2 = tempString;
									}
									print = false;
									// ifst.setIfHasBeenClosed(true);
								}

								tempstr = "";
								boolean bc = false;

								if (info[currentForIndex - 1] != JvmOpCodes.DCMPG
										&& info[currentForIndex - 1] != JvmOpCodes.DCMPL
										&& info[currentForIndex - 1] != JvmOpCodes.FCMPG
										&& info[currentForIndex - 1] != JvmOpCodes.FCMPL
										&& info[currentForIndex - 1] != JvmOpCodes.LCMP) {
									tempString = "\nif(" + op.getOperandValue()
											+ " > 0)\n{\n";
									tempstr = op.getOperandValue() + "<= 0";
								} else {
									tempString = "\nif(" + op.getOperandValue()
											+ " )\n{\n";
									tempstr = op.getOperandValue();
									bc = true;
								}

								java.lang.String alt;
								if (bc == false) {
									alt = op.getOperandValue() + "> 0";
									;
								} else {
									alt = op.getOperandValue();
								}

								boolean last = IFHelper.lastIFinShortCutChain(
										info, ifst, currentForIndex);
								boolean c = IFHelper
										.addCodeStatementWRTShortcutOR(ifst,
												tempstr, print, "if", last, alt);
								if (c) {
									if (addifbreak) {
										behavior.appendToBuffer( Util
												.formatDecompiledStatement(tempString2));
									}
									behavior.appendToBuffer( Util
											.formatDecompiledStatement(tempString));
								} else {
									boolean firstIfForLoop = LoopHelper
											.isIfFirstIfInLoopCondition(info,
													currentForIndex);
									if (firstIfForLoop) {
										IFHelper
												.registerElseBreakForIfChain(currentForIndex);
									}
								}

								break;
							}
						}
						if (isInfiniteLoop) {
							GlobalVariableStore
									.setEncounteredAndOrComp(encounteredAndOrComp);
							GlobalVariableStore.setIfInScope(isIfInScope);
							GlobalVariableStore.setThisLoop(thisLoop);
							
							return;
						}
						tempstr = "";
						boolean bc = false;
						if (info[currentForIndex - 1] != JvmOpCodes.DCMPG
								&& info[currentForIndex - 1] != JvmOpCodes.DCMPL
								&& info[currentForIndex - 1] != JvmOpCodes.FCMPG
								&& info[currentForIndex - 1] != JvmOpCodes.FCMPL
								&& info[currentForIndex - 1] != JvmOpCodes.LCMP) {
							tempString = "\nwhile(" + op.getOperandValue()
									+ " > 0)\n{\n";
							tempstr = op.getOperandValue() + " <= 0";
						} else {
							tempString = "\nwhile(" + op.getOperandValue()
									+ ")\n{\n";
							tempstr = op.getOperandValue();
							bc = true;
						}
						java.lang.String alt;
						if (bc == false) {
							alt = op.getOperandValue() + "> 0";
							;
						} else {
							alt = op.getOperandValue();
						}

						boolean last = IFHelper.lastIFinShortCutChain(info,
								ifst, currentForIndex);
						boolean c = IFHelper.addCodeStatementWRTShortcutOR(
								ifst, tempstr, true, "while", last, alt);
						if (c)
							behavior.appendToBuffer( Util
									.formatDecompiledStatement(tempString));

					} else {
						/*
						 * ifLevel++; ifst = new IFBlock();
						 * ifst.setIfStart(currentForIndex);
						 * ifst.setHasIfBeenGenerated(true);
						 */
						ifst.setElseCloseLineNumber(gotoIndex);
						/*
						 * ifHashTable.put(""+(ifLevel),ifst); int
						 * resetVal=checkIfElseCloseNumber(classIndex-3,ifst);
						 * ifst.setIfCloseLineNumber(resetVal); isIfInScope =
						 * true;
						 */
						isIfInScope = true;
						// addBranchLabel(classIndex,i,ifst,currentForIndex,info);
						boolean bb = LoopHelper.isBeyondLoop(getGenericFinder()
								.getJumpAddress(currentForIndex), getContext()
								.getBehaviourLoops(), info);
                        thisLoop = GlobalVariableStore.getThisLoop();
                        boolean print = true;
						boolean addifbreak = false;
						java.lang.String tempString2 = "";

						if (bb && thisLoop != null && thisLoop.isInfinite()
								&& !encounteredAndOrComp && addBreak) {
							Loop dowl = LoopHelper.isIfInADoWhile(
									currentForIndex, ifst, getContext()
											.getBehaviourLoops());
							if (dowl != null) {
								tempString = "";
							} else {
								if (info[currentForIndex - 1] != JvmOpCodes.DCMPG
										&& info[currentForIndex - 1] != JvmOpCodes.DCMPL
										&& info[currentForIndex - 1] != JvmOpCodes.FCMPG
										&& info[currentForIndex - 1] != JvmOpCodes.FCMPL
										&& info[currentForIndex - 1] != JvmOpCodes.LCMP)
									tempString = "\nif(" + op.getOperandValue()
											+ "<=0)\n{\nbreak;\n}\n";

								else
									tempString = "\nif(" + op.getOperandValue()
											+ ")\n{\nbreak;\n}\n";
								// codeStatements
								// +=Util.formatDecompiledStatement(tempString);
								tempString2 = tempString;
								addifbreak = true;
							}
							print = false;
							// ifst.setIfHasBeenClosed(true);
						}

						tempstr = "";
						boolean bc = false;
						if (info[currentForIndex - 1] != JvmOpCodes.DCMPG
								&& info[currentForIndex - 1] != JvmOpCodes.DCMPL
								&& info[currentForIndex - 1] != JvmOpCodes.FCMPG
								&& info[currentForIndex - 1] != JvmOpCodes.FCMPL
								&& info[currentForIndex - 1] != JvmOpCodes.LCMP) {
							tempString = "\nif(" + op.getOperandValue()
									+ " > 0)\n{\n";
							tempstr = op.getOperandValue() + " <= 0";
						} else {
							tempString = "\nif(" + op.getOperandValue()
									+ " )\n{\n";
							tempstr = op.getOperandValue();
							bc = true;
						}
						java.lang.String alt;
						if (bc == false) {
							alt = op.getOperandValue() + "> 0";
							;
						} else {
							alt = op.getOperandValue();
						}

						boolean last = IFHelper.lastIFinShortCutChain(info,
								ifst, currentForIndex);
						boolean c = IFHelper.addCodeStatementWRTShortcutOR(
								ifst, tempstr, print, "if", last, alt);
						if (c) {
							if (addifbreak) {
								behavior.appendToBuffer( Util
										.formatDecompiledStatement(tempString2));
							}
							behavior.appendToBuffer( Util
									.formatDecompiledStatement(tempString));
						} else {
							boolean firstIfForLoop = LoopHelper
									.isIfFirstIfInLoopCondition(info,
											currentForIndex);
							if (firstIfForLoop) {
								IFHelper
										.registerElseBreakForIfChain(currentForIndex);
							}
						}

					}

			} else {
				/*
				 * ifLevel++; ifst = new IFBlock();
				 * ifst.setIfStart(currentForIndex);
				 * ifst.setHasIfBeenGenerated(true);
				 * ifHashTable.put(""+(ifLevel),ifst);
				 */
				isIfInScope = true;
				// addBranchLabel(classIndex,i,ifst,currentForIndex,info);
				boolean bb = LoopHelper.isBeyondLoop(getGenericFinder()
						.getJumpAddress(currentForIndex), getContext()
						.getBehaviourLoops(), info);
                thisLoop = GlobalVariableStore.getThisLoop();
                boolean print = true;
				boolean addifbreak = false;
				java.lang.String tempString2 = "";
				if (bb && thisLoop != null && thisLoop.isInfinite()
						&& !encounteredAndOrComp && addBreak) {
					Loop dowl = LoopHelper.isIfInADoWhile(currentForIndex,
							ifst, getContext().getBehaviourLoops());
					if (dowl != null) {
						tempString = "";
					} else {
						if (info[currentForIndex - 1] != JvmOpCodes.DCMPG
								&& info[currentForIndex - 1] != JvmOpCodes.DCMPL
								&& info[currentForIndex - 1] != JvmOpCodes.FCMPG
								&& info[currentForIndex - 1] != JvmOpCodes.FCMPL
								&& info[currentForIndex - 1] != JvmOpCodes.LCMP)
							tempString = "\nif(" + op.getOperandValue()
									+ "<=0)\n{\nbreak;\n}\n";

						else
							tempString = "\nif(" + op.getOperandValue()
									+ ")\n{\nbreak;\n}\n";
						tempString2 = tempString;
						addifbreak = true;
						// codeStatements
						// +=Util.formatDecompiledStatement(tempString);
					}
					print = false;
				}
				// ifst.setIfHasBeenClosed(true);
				tempstr = "";
				boolean bc = false;
				if (info[currentForIndex - 1] != JvmOpCodes.DCMPG
						&& info[currentForIndex - 1] != JvmOpCodes.DCMPL
						&& info[currentForIndex - 1] != JvmOpCodes.FCMPG
						&& info[currentForIndex - 1] != JvmOpCodes.FCMPL
						&& info[currentForIndex - 1] != JvmOpCodes.LCMP) {
					tempString = "\nif(" + op.getOperandValue() + " > 0)\n{\n";
					tempstr = op.getOperandValue() + " <= 0";
				} else {
					tempString = "\nif(" + op.getOperandValue() + " )\n{\n";
					tempstr = op.getOperandValue();
					bc = true;
				}
				java.lang.String alt;
				if (bc == false) {
					alt = op.getOperandValue() + "> 0";
					;
				} else {
					alt = op.getOperandValue();
				}

				boolean last = IFHelper.lastIFinShortCutChain(info, ifst,
						currentForIndex);
				boolean c = IFHelper.addCodeStatementWRTShortcutOR(ifst,
						tempstr, print, "if", last, alt);
				if (c) {
					if (addifbreak) {
						behavior.appendToBuffer( Util
								.formatDecompiledStatement(tempString2));
					}
					behavior.appendToBuffer( Util
							.formatDecompiledStatement(tempString));
				}

				else {
					boolean firstIfForLoop = LoopHelper
							.isIfFirstIfInLoopCondition(info, currentForIndex);
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
