package test;

public class CengjiArrays {

	
	public static void main(String[] args)
	{
		double[][] dd=new double[5][10];
		for(int i=0;i<5;i++)
			for(int j=0;j<10;j++)
				dd[i][j]=i*100+j;
		Object t=dd;
		Object[] d=(Object[])t;
		for(int i=0;i<d.length;i++)
		{
			double[] di=(double[])d[i];
			for(int j=0;j<di.length;j++)
			{
				System.out.print(di[j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
}
