package org.wzy.unit.impl;

import org.wzy.tool.MatrixTool;
import org.wzy.unit.Unit;

public class AddUnit implements Unit{

	
	
	@Override
	public Object forward(Object input) {
		// TODO Auto-generated method stub
		boolean flag=true;
		Object[] inputs=(Object[])input;
		if(inputs.length==0)
			return null;
		else if(inputs.length==1)
			return inputs[0];
		else
		{
			if(inputs[0] instanceof double[][])
			{
				double[][] res=new double[((double[][])inputs[0]).length][((double[][])inputs[0])[0].length];
				for(int i=0;i<inputs.length;i++)
				{
					flag&=MatrixTool.MatrixAddSelf(res, (double[][])inputs[i]);
				}
				if(!flag)
					res=null;
				return res;
			}
			else if (inputs[0] instanceof double[])
			{
				double[] res=new double[((double[])inputs[0]).length];
				for(int i=0;i<inputs.length;i++)
				{
					flag&=MatrixTool.VectorAddSelf(res, (double[])inputs[i]);
				}
				if(!flag)
					res=null;
				return res;				
			}
			return null;
		}
	}

	@Override
	public Object backward(Object grad_output) {
		// TODO Auto-generated method stub
		Object[] grad_inputs= new Object[2];
		grad_inputs[0]=grad_output;
		grad_inputs[1]=grad_output;
		return grad_inputs;
	}

}
