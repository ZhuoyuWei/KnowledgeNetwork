package org.wzy.unit.impl;

import java.util.List;

import org.wzy.unit.Unit;

public class UnitParallel implements Unit{
	
	public List<Unit> unitList;

	@Override
	public Object forward(Object input) {
		// TODO Auto-generated method stub
		if(unitList==null)
			return null;
		Object[] res=new Object[unitList.size()];
		Object[] inputs=(Object[])input;
		for(int i=0;i<res.length;i++)
		{
			res[i]=unitList.get(i).forward(inputs[i]);
		}
		return res;
	}

	@Override
	public Object backward(Object grad_output) {
		// TODO Auto-generated method stub
		if(unitList==null)
			return null;
		Object[] grad_inputs=new Object[unitList.size()];
		Object[] grad_outputs=(Object[])grad_output;
		for(int i=0;i<unitList.size();i++)
		{
			grad_inputs[i]=unitList.get(i).backward(grad_outputs[i]);
		}		
		return grad_inputs;
	}

	
}
