package com.practice.Collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		Map<Integer, Mobile> m=new TreeMap<Integer, Mobile>();
		Mobile m1=new Mobile(12000, "iQOO Z6", "IQOO");
		Mobile m2=new Mobile(15500, "VIVO Z9", "VIVO");
		Mobile m3=new Mobile(32000, "IQOO Legend", "IQOO");
		
		m.put(101, m1);
		m.put(102, m2);
		m.put(103, m3);
		for(Map.Entry<Integer, Mobile> entry: m.entrySet()) {
			Mobile mn=entry.getValue();
			System.out.println(mn.price+" "+mn.name+" "+mn.manufacturer);
		}
	}

}
class Mobile{
	int price;
	String name;
	String manufacturer;
	public Mobile(int price, String name, String manufacturer) {
		super();
		this.price = price;
		this.name = name;
		this.manufacturer = manufacturer;
	}
	
	
}
