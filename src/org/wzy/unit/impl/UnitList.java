package org.wzy.unit.impl;

import java.util.List;

import org.wzy.unit.Unit;

public class UnitList implements Unit {

	
	public List<Unit> unitList;

	@Override
	public Object forward(Object input) {
		// TODO Auto-generated method stub
		if(unitList==null)
			return null;
		Object tmp=input;
		for(int i=0;i<unitList.size();i++)
		{
			tmp=unitList.get(i).forward(tmp);
		}
		return tmp;
	}

	@Override
	public Object backward(Object grad_output) {
		// TODO Auto-generated method stub
		if(unitList==null)
			return null;
		Object tmp=grad_output;
		for(int i=unitList.size()-1;i>=0;i--)
		{
			tmp=unitList.get(i).backward(grad_output);
		}
		return tmp;
	}

}
