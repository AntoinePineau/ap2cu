package com.ap2cu.applets.decompiler.core;

import com.ap2cu.applets.decompiler.blocks.IFBlock;


public class TernaryTracker {
        IFBlock ifs=null;
        int ternary=-1;
        int conditionTernaryEnd=-1;

        public boolean isParentif() {
            return parentif;
        }

        boolean parentif=false;


        public TernaryTracker(IFBlock ifst,int tend,int cTend,boolean parentif) {
            ifs=ifst;
            ternary = tend;
            conditionTernaryEnd=cTend;
            this.parentif=parentif;
        }

        public IFBlock getIF() {
            return ifs;
        }

        public int getTEnd() {
            return ternary;
        }

        public int getConditionTernaryEnd() {
            return conditionTernaryEnd;
        }
    }
