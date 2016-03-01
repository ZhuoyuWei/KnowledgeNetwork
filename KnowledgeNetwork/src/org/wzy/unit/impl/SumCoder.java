package org.wzy.unit.impl;

import org.wzy.frame.KNTraining;
import org.wzy.tool.MatrixTool;
import org.wzy.unit.Coder;

public class SumCoder implements Coder{
	
	@Override
	public double[] encode_rt(int r, int t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void encode(int h, int r, int t) {
		// TODO Auto-generated method stub
		double[] tmp=encode_rt(r,t);
		MatrixTool.VectorAdd(KNTraining.uniqueInstanse.entity_embedding[h],tmp);
		double norm=MatrixTool.VectorNorm2(KNTraining.uniqueInstanse.entity_embedding[h]);
		if(norm>1)
			MatrixTool.VectorNorm2Self(KNTraining.uniqueInstanse.entity_embedding[h], norm);
	}

	@Override
	public double[] decode(int h, int r) {
		// TODO Auto-generated method stub
		double[] res=new double[KNTraining.uniqueInstanse.entity_embedding[h].length];
		MatrixTool.VectorMinus(KNTraining.uniqueInstanse.entity_embedding[h], KNTraining.uniqueInstanse.entity_embedding[h]);
		return null;
	}



}
