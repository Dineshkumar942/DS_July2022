package com.practice;

public class Printer {

	public static void main(String[] args) {
		EpsonPrinter ep1 = new EpsonPrinter(5, "Salary Slip", "RKR43", "SNM3");
		ep1.PrintDoc();
		ep1.toString();
		EpsonPrinter ep2=new EpsonPrinter(6, "Appointment Letter", "HRI4", "RKR43");
		ep2.PrintDoc();
		EpsonPrinter ep3=new EpsonPrinter();
		ep3.PrintDoc();
		System.out.println("EpsonPrinter1 : "+ep1);
		System.out.println("EpsonPrinter2 : "+ep2);
		System.out.println("EpsonPrinter 1 : "+ep1);
		System.out.println("EpsonPrinter 2 :"+ep2);
		
	}

}

class EpsonPrinter{
	private int noOfPages;
	private String desc;
	private String src;
	private String dst;
	
	EpsonPrinter(int a,String b,String c,String d) {
		noOfPages=a;
		desc=b;
		src=c;
		dst=d;
	}
	
	EpsonPrinter(int a,String b){
		noOfPages=a;
		desc=b;
	}
	EpsonPrinter(){
		
	}
	
	
	@Override
	public String toString() {
		return "EpsonPrinter [noOfPages=" + noOfPages + ", desc=" + desc + ", src=" + src + ", dst=" + dst + "]";
	}

	void PrintDoc() {
		System.out.println("Printing a doc with "+noOfPages+" pages described as : "+desc+" sender is : "+src+" and the receiver is :  "+dst);
		System.out.println("----------------------------");
	}
	void PrintDoc(int no,String des) {
		System.out.println("Printing a doc with "+no+" pages described as : "+des);
		System.out.println("----------------------------");
	}
}
