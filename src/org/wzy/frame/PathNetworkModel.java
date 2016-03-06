package org.wzy.frame;

import java.util.Random;

public class PathNetworkModel {

	public double[][] relation_decoders;
	
	public double[][] filter_matrix;
	public double[][] filter_matrix_gradients;
	
	public int dim;
	private Random rand=new Random();
	
	public void InitRandomly()
	{
		relation_decoders=new double[KNTraining.uniqueInstanse.getEntityNum()][dim];
		for(int i=0;i<relation_decoders.length;i++)
		{
			for(int j=0;j<relation_decoders[i].length;j++)
			{
				relation_decoders[i][j]=rand.nextDouble();
			}
		}
		
		
		
		filter_matrix=new double[2*dim][dim];
		for(int i=0;i<filter_matrix.length;i++)
		{
			for(int j=0;j<filter_matrix[i].length;j++)
			{
				filter_matrix[i][j]=rand.nextDouble();
			}
		}

	}
	
	
	
	/*public double[] inference_forward(int e,int r)
	{
		
	}
	public double[] inference_backward()
	{}*/
	
	
	public double scoring(int[] triplet)
	{
		
	}
	
	
}
