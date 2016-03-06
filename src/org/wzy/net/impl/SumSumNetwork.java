package org.wzy.net.impl;

import java.util.ArrayList;
import java.util.List;

import org.wzy.net.Network;
import org.wzy.unit.Unit;
import org.wzy.unit.impl.AddUnit;
import org.wzy.unit.impl.UnitIterator;
import org.wzy.unit.impl.UnitList;


/**
 * To calculate the new embedding for the head entity by its all relations and tail entities.
 * The parallel structure we use SUM
 * The sequence structure we use SUM
 * Therefore, we called the method as SumSumNetwork
 * @author zhuoyu wei
 *
 */
public class SumSumNetwork implements Unit,Network{

	
	private UnitList network;
	
	@Override
	public Object forward(Object input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object backward(Object grad_output) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ConstructNetwork() {
		// TODO Auto-generated method stub
		
		AddUnit add_r_t=new AddUnit();
		UnitIterator ui=new UnitIterator();
		ui.unit=add_r_t;

		network=new UnitList();
		network.unitList.add(ui);
		network.unitList.add(new AddUnit());
			
	}

	/**
	 * Sum-Sum-Network ShareConstructNetwork
	 * @param share_units has two addunits:
	 * 		  share_units[0] is add r and t
	 * 		  share_units[1] is add all iterator t for the h entity
	 */
	@Override
	public void ShareConstructNetwork(Unit[] share_units) {
		// TODO Auto-generated method stub
		
		UnitIterator ui=new UnitIterator();
		ui.unit=share_units[0];

		network=new UnitList();
		network.unitList.add(ui);
		network.unitList.add(share_units[1]);
		
	}

}
