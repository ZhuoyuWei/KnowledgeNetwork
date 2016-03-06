package org.wzy.frame;

import java.util.Random;
import java.util.concurrent.Callable;

import org.wzy.net.impl.SumSumNetwork;
import org.wzy.tool.MatrixTool;

public class CompelteTraingingThread implements Callable{

	private int MaxEpoch=100;
	private Random rand=new Random();
	
	private SumSumNetwork network;
	
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
	
	
	private double[][][] ProduceTraningDataForHentity(int[][] rtindexs)
	{
		double[][][] embeddings=new double[rtindexs.length][2][];
		for(int i=0;i<rtindexs.length;i++)
		{
			embeddings[i][0]=KNTraining.uniqueInstanse.relation_embedding[rtindexs[i][0]];
			embeddings[i][1]=KNTraining.uniqueInstanse.entity_embedding[rtindexs[i][1]];
		}
		return embeddings;
	}
	
	public void Training()
	{
		//init sum-sum-network
		network=new SumSumNetwork();
		network.ConstructNetwork();
		for(int epoch=0;epoch<MaxEpoch;epoch++)
		{
			int[] orders=RandomSort(KNTraining.uniqueInstanse.getEntityNum()*10);
			for(int i=0;i<orders.length;i++)
			{
				int hindex=orders[i];
				int[][] rtindexs=KNTraining.uniqueInstanse.knGraph[hindex];
				
				//complete replace h entity's embedding by the sum of its r_t pairs
				double[][][] input_embeddings=ProduceTraningDataForHentity(rtindexs);
				KNTraining.uniqueInstanse.entity_embedding[hindex]=(double[])network.forward(input_embeddings);
				//norm the new embeddings
				MatrixTool.VectorNorm2(KNTraining.uniqueInstanse.entity_embedding[hindex]);
			}
		}
	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		
		Training();
		
		return null;
	}
	
	
	
}
