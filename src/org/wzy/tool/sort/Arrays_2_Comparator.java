package org.wzy.tool.sort;

import java.util.Comparator;

public class Arrays_2_Comparator implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		int[] a1=(int[])arg0;
		int[] a2=(int[])arg1;
		
		if(a1[0]<a2[0])
			return -1;
		else if(a1[0]>a2[0])
			return 1;
		else
		{
			if(a1[1]<a2[1])
				return -1;
			else if(a1[1]>a2[1])
				return 1;
			else
				return 0;
		}

	}

}
