package org.wzy.unit;

public interface Unit {

/*	double[] forward_i2o2(double[] a,double[] b);
	double[][] forward_i2o3(double[] a,double[] b);
	double[] forward_i3o2(double[][] a,double[][] b);
	double[][] forward_i3o3(double[][] a,double[][] b);
	
	double[] backward_i2o2(double[] a,double[] b);
	double[][] backward_i2o3(double[] a,double[] b);
	double[] backward_i3o2(double[][] a,double[][] b);
	double[][] backward_i3o3(double[][] a,double[][] b);*/	
	
	Object forward(Object input);
	Object backward(Object grad_output);	
}
