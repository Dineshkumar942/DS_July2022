package com.practice;

import java.util.Scanner;

public class Laptop {

	public static void main(String[] args) {
		Lappy HP=new Lappy();
		HP.setProps(45000, 8, "Pavilion");
		HP.checkPrice();
		HP.displayProps();
	}

}
class Lappy{
	float cost;
	int RAM;
	String model;
	Scanner at=new Scanner(System.in);
	void displayProps() {
		System.out.println("Cost : "+cost+"/-");
		System.out.println("RAM : "+ RAM+"GB");
	    System.out.println("Model : "+model);
	}
	void setProps(float c,int r,String m) {
		cost=c;
		RAM=r;
		model=m;
	}
	void checkPrice() {
		System.out.println("Enter your budget: ");
		float askPrice=at.nextFloat();
		
		if(askPrice < 50000) {
			System.out.println("Laptop can be taken for less than 50k");
		}
		else {
			System.out.println("Laptop is more than 50k");
		}
	}
	
	
}
