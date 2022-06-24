package player;

import Interface.IPlayer;
import gameEngine.Grille;

public class IA implements IPlayer{
	String name;
	String symbol;
	
	
	public IA(String n, String s) {
		name=n;
		symbol=s;
	}
	
	@Override
	public int[] chooseCell(Grille g) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
