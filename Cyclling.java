package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import com.practice.exceptions.CycleChainBrokenException;
import com.practice.exceptions.StandNotLiftedException;


public class Cyclling {

	public static void main(String[] args) {
		System.out.println("Start of main");
		ArrayList<Cycle> list = new ArrayList<Cycle>();
		Cycle BSA=new Cycle(2,"Non-motor",false,"Girls");
		Cycle Hercules=new Cycle(2,"Non-motor",false,"Boys");
		Cycle XYZ=new Cycle(2,"motor",false,"Boys");
		list.add(Hercules);
		list.add(XYZ);
		list.add(BSA);
		for (Cycle cycle : list) {
			System.out.println(cycle);
		}
		FileHandlingCycle FHC = new FileHandlingCycle();
		try {
			
			FileInputStream fis = new FileInputStream("D:\\temp\\CycleInputFile.txt");
			FileOutputStream fos = new FileOutputStream("D:\\temp\\CycleOutputFile.txt");
			
			FHC.printCycleHistory(fis);
			FHC.readCycleData(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BSA.liftStand();
			BSA.startRide();
		}
		catch(StandNotLiftedException ex) {
			System.out.println(ex);
		}
		
		FHC.doExposeDetails(Hercules);
		System.out.println("End of main");
		

	}

}

class Cycle extends Vehicle implements Serializable{
	private boolean standStatus;	
	private String cycleType;
	
	
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
			double num=Math.random();
			if(num>0.97) {
				CycleChainBrokenException chainBroken = new CycleChainBrokenException("Chain broken.....");
				throw chainBroken;
			}
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

	public Cycle(int noOfWheels, String type, boolean standStatus, String cycleType) {
		super(noOfWheels, type);
		this.standStatus = standStatus;
		this.cycleType = cycleType;
	}

	@Override
	public String toString() {
		return "Cycle [standStatus=" + standStatus + ", cycleType=" + cycleType + "]";
	}

	
	
	
}
class FileHandlingCycle{
	void printCycleHistory(FileInputStream fis) {
		try {
			byte b = (byte)fis.read();
			while(b!=-1) {
				System.out.print((char)b);
				//Thread.sleep(100);
				b=(byte)fis.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void readCycleData(FileOutputStream fos) {
		Scanner at = new Scanner(System.in);
		System.out.println("Please Enter data about Cycle : ");
		String data=at.nextLine();
		byte b[]=data.getBytes();
		try {
			fos.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			at.close();
		}
		System.out.println("Data inserted into file successfully.....");
	}
	void doExposeDetails(Cycle x) {
		try {
			FileOutputStream fout=new FileOutputStream("D://temp//CycleSerializer.txt");
			System.out.println("File is ready");
			ObjectOutputStream oos=new ObjectOutputStream(fout);
			System.out.println("Object is ready");
			oos.writeObject(x);
			System.out.println("Process completed");
			oos.close();
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
