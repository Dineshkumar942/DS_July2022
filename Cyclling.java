package com.practice;

public class Cyclling {

	public static void main(String[] args) {
		System.out.println("Start of main");
		Cycle BSA = new Cycle();
		try {
			BSA.liftStand();
			BSA.startRide();
		}
		catch(StandNotLiftedException ex) {
			System.out.println(ex);
		}
		System.out.println("End of main");
		

	}

}
class StandNotLiftedException extends Exception{
	StandNotLiftedException(String msg){
		super(msg);
	}
}
class Cycle{
	boolean standStatus;	
	
	Cycle(){
		System.out.println("Cycle is ready....");
	}
	
	void liftStand() {
		if(standStatus == false) {
			standStatus=true;
		}
		System.out.println("Stand lifted successfully...");
	}
	
	void startRide() throws StandNotLiftedException {
		if(standStatus == false) {
			StandNotLiftedException stndlift = new StandNotLiftedException("The stand is yet to lift.....");
			throw stndlift;
		}
		System.out.println("Started initial ride with legs ...");
		pressPedals();
		System.out.println("Reached to destination....");
	}
	void pressPedals() {
		for(int i=0;i<10;i++) {
			System.out.println("MovingPedalsinClcokWiseDirection");
		}
		applyBreak();
	}
	void applyBreak() {
		System.out.println("Break Applied....");
	}
	void putStand() {
		if(standStatus==true) {
			standStatus=false;
		}
		System.out.println("Cycle is safe now....");
	}
	
}
