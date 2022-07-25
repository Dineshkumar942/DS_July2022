package com.practice;

public class InheritanceTest {

	public static void main(String[] args) {
		Telephone tpObj=new Telephone(678493, "TMC", "BSNL");
		tpObj.printTelephone();
		System.out.println("-------------");
		CellPhone cpObj=new CellPhone(678493, "TMC", "BSNL", "Philips", "2GB", "3inch");
		cpObj.printCellPhone();
		System.out.println("-------------");
		SmartMobile smObj=new SmartMobile(678493, "TMC", "BSNL", "Philips", "2GB", "3inch","50MP", "5G", "Amazon");
		smObj.printSmartMobile();
		System.out.println("-------------");
	}

}
class Telephone{
	private long number;
	private String manufacturer;
	private String network;
	
		
	public Telephone(long number, String manufacturer, String network) {
		super();
		this.number = number;
		this.manufacturer = manufacturer;
		this.network = network;
	}

	public void printTelephone() {
		System.out.println("Number : "+number);
		System.out.println("Manufacturer : "+manufacturer);
		System.out.println("WireLength : "+network);
	}
}
class CellPhone extends Telephone{
	private String speaker;
	private String storage;
	private String height;
	
	
	
	
	public CellPhone(long number, String manufacturer, String network, String speaker, String storage,
			String height) {
		super(number, manufacturer, network);
		this.speaker = speaker;
		this.storage = storage;
		this.height = height;
	}




	public void printCellPhone() {
		super.printTelephone();
		System.out.println("Speaker : "+speaker);
		System.out.println("Storage : "+storage);
		System.out.println("Alaram Feature : "+height);
	}
}
class SmartMobile extends CellPhone{
	private String camera;
	private String internet;
	private String apps;
	
	
	
	public SmartMobile(long number, String manufacturer, String network, String speaker, String storage,
			String height, String camera, String internet, String apps) {
		super(number, manufacturer, network, speaker, storage, height);
		this.camera = camera;
		this.internet = internet;
		this.apps = apps;
	}



	public void printSmartMobile() {
		super.printCellPhone();
		System.out.println("Camera : "+camera);
		System.out.println("Internet : "+internet);
		System.out.println("Apps : "+apps);
	}
}
