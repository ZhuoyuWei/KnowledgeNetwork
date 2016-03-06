package org.wzy.unit.impl;

import org.wzy.unit.Unit;

public class UnitIterator implements Unit{

	public Unit unit;
	
	@Override
	public Object forward(Object input) {
		// TODO Auto-generated method stub
		

		
		Object[] inputs=(Object[])input;
		Object[] outputs=new Object[inputs.length];
		
		for(int i=0;i<inputs.length;i++)
		{
			outputs[i]=unit.forward(inputs[i]);
		}
		
		return outputs;
	}

	@Override
	public Object backward(Object grad_output) {
		// TODO Auto-generated method stub
		if(unit==null)
		{
			System.err.println("Undefine Iteraotr unit.");
			return null;
		}		
		
		Object[] grad_outputs=(Object[])grad_output;
		Object[] grad_inputs=new Object[grad_outputs.length];
		
		for(int i=0;i<grad_outputs.length;i++)
		{
			grad_inputs[i]=unit.backward(grad_outputs[i]);
		}
		
		return grad_inputs;
	}

}
