package org.wzy.unit.impl;

import org.wzy.unit.Unit;

public class CatUnit implements Unit{

	@Override
	public Object forward(Object input) {
		// TODO Auto-generated method stub
		
		Object[][] inputs=(Object[][])input;
		
		if(inputs.length!=2||inputs[0].length!=inputs[1].length)
		{
			System.err.println("Cat Unit Error.");
		}
		
		Object[] output=new Object[inputs[0].length*2];
		for(int i=0;i<inputs[0].length;i++)
			output[i]=inputs[0][i];
		for(int i=0;i<inputs[1].length;i++)
			output[i+inputs[0].length]=inputs[1][i];
		
		return output;
	}

	@Override
	public Object backward(Object grad_output) {
		// TODO Auto-generated method stub
		
		Object[] grads=(Object[]) grad_output;
		Object[][] grad_inputs=new Object[2][grads.length/2];
		
		for(int i=0;i<grad_inputs[0].length;i++)
			grad_inputs[0][i]=grads[i];
		for(int i=0;i<grad_inputs[1].length;i++)
			grad_inputs[1][i]=grads[i+grad_inputs[0].length];
		
		
		return grad_inputs;
	}
	
	
	
/*	@Override
	public Object forward(Object input) {
		// TODO Auto-generated method stub
		
		Object[][] inputs=(Object[][])input;
		
		int out_sum=0;
		for(int i=0;i<inputs.length;i++)
			out_sum+=inputs[i].length;
		
		Object[] output=new Object[out_sum];
		int count=0;
		for(int i=0;i<inputs.length;i++)
		{
			for(int j=0;j<inputs[i].length;j++)
			{
				output[count++]=inputs[i][j];
			}
		}
		
		
		return output;
	}*/

}
