package com.practice.Collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class CricketPlayerTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		CricketPlayer c1=new CricketPlayer("Virat", 183, 125.5f);
		CricketPlayer c2=new CricketPlayer("Root", 143, 135.5f);
		CricketPlayer c3=new CricketPlayer("Smith", 173, 110.5f);
		
		TreeSet<CricketPlayer> ts=new TreeSet<CricketPlayer>();
		ts.add(c1);	
		ts.add(c2);
		ts.add(c3);
		
		HighestScoreComparator hiComp=new HighestScoreComparator();
		Collections.sort((List<CricketPlayer>)ts, hiComp);
		for (CricketPlayer cricketPlayer : ts) {
			System.out.println(cricketPlayer);
		}
		
		
	}

}
class CricketPlayer{
	String playerName;
	int highestScore;
	float strikeRate;
	public CricketPlayer(String playerName, int highestScore, float strikeRate) {
		super();
		this.playerName = playerName;
		this.highestScore = highestScore;
		this.strikeRate = strikeRate;
	}
			
}
class HighestScoreComparator implements Comparator<CricketPlayer>{

	@Override
	public int compare(CricketPlayer o1, CricketPlayer o2) {
		return Integer.compare(o1.highestScore, o2.highestScore);
	}
	
}
