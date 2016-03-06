package org.wzy.unit.impl;

import org.wzy.tool.MatrixTool;
import org.wzy.unit.Unit;

public class LinearNBUnit implements Unit{

	public double[][] weights;
	public double[][] weights_gradients;
	
	
	@Override
	public Object forward(Object input) {
		// TODO Auto-generated method stub
		
		double[] inputs=(double[])input;
		double[] output=MatrixTool.VectorRightDotMatrix(inputs, weights);
		
		return output;
	}

	@Override
	public Object backward(Object grad_output) {
		// TODO Auto-generated method stub
		
		double[] grads=(double[])grad_output;
		
		//for weights
		weights_gradients=new double[weights.length][];
		for(int i=0;i<weights.length;i++)
		{
			weights_gradients[i]=grads;
		}
		
		//for grad_inputs
		double[] grad_inputs=MatrixTool.MatrixRightDotVector(weights, grads);
		return grad_inputs;
	}

}
