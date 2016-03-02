package org.wzy.frame;

import java.util.Random;

public class CompelteTraingingThread {

	private int MaxEpoch=100;
	private Random rand=new Random();
	
	public int[] TopologySort()
	{
		int[] orders=new int[KNTraining.uniqueInstanse.getEntityNum()];
		for(int i=0;i<orders.length;i++)
			orders[i]=i;
		return orders;
	}
	
	public int[] RandomSort(int n)
	{
		int[] orders=new int[KNTraining.uniqueInstanse.getEntityNum()];
		for(int i=0;i<orders.length;i++)
			orders[i]=i;
		for(int i=0;i<n;i++)
		{
			int a=Math.abs(rand.nextInt())%orders.length;
			int b=Math.abs(rand.nextInt())%orders.length;	
			if(a<0||a>=orders.length||b<0||b>=orders.length||a==b)
				continue;
			int t=orders[a];
			orders[a]=orders[b];
			orders[b]=t;
		}
		return orders;
	}
	
	public void Training()
	{
		for(int epoch=0;epoch<MaxEpoch;epoch++)
		{
			int[] orders=RandomSort(KNTraining.uniqueInstanse.getEntityNum()*10);
			for(int i=0;i<orders.length;i++)
			{
				
			}
		}
	}
	
	
	
}
