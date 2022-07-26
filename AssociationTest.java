package com.practice;

import java.time.LocalDate;

public class AssociationTest {

	public static void main(String[] args) {
		Player p1=new Player("Cricket","Male","Sachin");
		CricketPlayer cp=new CricketPlayer(p1,"10","Bat&Ball",2);
		Stadium wankhade = new Stadium("Wankhade","Mumbai",65000);
		Teams teams=new Teams("AUS","IND",11);
		cp.playMatch(wankhade, LocalDate.of(2022, 10, 20),teams);

	}

}
class Player{
	String sport;
	String gender;
	String name;
	public Player(String sport, String gender, String name) {
		super();
		this.sport = sport;
		this.gender = gender;
		this.name = name;
	}
	
	void printPlayer() {
		System.out.println("+-----Player Info---------");
		System.out.println("Name : "+name);
		System.out.println("Gender : "+gender);
		System.out.println("sport : "+sport);
		System.out.println("+--------------------------");
	}
	
}
class CricketPlayer extends Player{
	String number;
	String objectUsed;
	int numOfObjectsUsed;
	

	public CricketPlayer(Player p, String number, String objectUsed,
			int numOfObjectsUsed) {
		super(p.sport, p.gender, p.name);
		this.number = number;
		this.objectUsed = objectUsed;
		this.numOfObjectsUsed = numOfObjectsUsed;
	}

	void playMatch(Stadium stadium, LocalDate date, Teams team) {
		System.out.println("Match venue is : "+stadium.name+" located at "+stadium.location+" on "+date+" between "+team.hostingTeam+" and "+team.OpponentTeam);
	}
}
class Stadium{
	String name;
	String location;
	long capacity;
	public Stadium(String name, String location, long capacity) {
		super();
		this.name = name;
		this.location = location;
		this.capacity = capacity;
	}
	
	void printStadium() {
		System.out.println("Stadium Name : "+name);
		System.out.println("Stadium Located in : "+location);
		System.out.println("Stadium can host : "+capacity);
	}
}
class Teams{
	String hostingTeam;
	String OpponentTeam;
	int noOfPlayers;
	public Teams(String hostingTeam, String opponentTeam, int noOfPlayers) {
		super();
		this.hostingTeam = hostingTeam;
		OpponentTeam = opponentTeam;
		this.noOfPlayers = noOfPlayers;
	}
	
	
}

