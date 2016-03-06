package org.wzy.frame;

import java.util.Random;

public class RandomTrainingThread {


	private int MAX_STEPS;
	private Random rand=new Random();
	
	
	public void Training(int startEntity)
	{
		for(int i=0;i<MAX_STEPS;i++)
		{
			int[] predecessors=KNTraining.uniqueInstanse.reverse_knGraph[startEntity];
			if(predecessors==null||predecessors.length<1)
			{
				startEntity=restart();
			}
			else
			{
				int randindex=Math.abs(rand.nextInt())%predecessors.length;
				
			}
				
		}
	}
	
	public int restart()
	{
		return Math.abs(rand.nextInt())%KNTraining.uniqueInstanse.getEntityNum();
	}
	
	
	
}
