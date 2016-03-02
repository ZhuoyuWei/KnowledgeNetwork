package org.wzy.unit;

public interface Coder {

	double[] encode_rt(int r,int t);
	void encode(int h,int r,int t);
	double[] decode(int h,int r);	
	
}
