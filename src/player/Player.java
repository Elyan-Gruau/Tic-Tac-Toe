package player;

import Interface.IPlayer;

public class Player implements IPlayer {
	String name;
	String symbol;
	public Player(String n, String s) {
		name=n;
		symbol=s;
	}
	
}
