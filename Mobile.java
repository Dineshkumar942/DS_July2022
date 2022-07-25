package com.practice;

public class Mobile {

	public static void main(String[] args) {
		IQOO z6=new IQOO();
		z6.model();
		z6.model(6);
		z6.model(16500.0f);
		z6.model(14.500f, 18.000f);
		z6.model(6, 16.699f);
	}

}
class IQOO{
	void model() {
		System.out.println("Basic model with 44W Charging");
	}
	void model(int RAM) {
		System.out.println("IQOO Model with 44W Charging capactiy and RAM is :"+RAM+"GB");
	}
	void model(int RAM,int storage) {
		System.out.println("IQOO Model with 44W Charging capactiy and RAM is :"+RAM+" and gives you "+storage+"GB");
	}
	void model(float price) {
		System.out.println("IQOO mobile costs you around "+price+"/-");
	}
	void model(float minPrice,float maxPrice) {
		System.out.println("IQOO Mobile price is in between "+minPrice+" - "+maxPrice);
	}
	void model(int RAM,float price) {
		System.out.println("IQOO Z6 5G is available with "+RAM+"GB and Price is "+price+"/-");
	}
	
}
