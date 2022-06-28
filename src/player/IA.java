package player;

import java.util.Random;

import Interface.IPlayer;
import gameEngine.Grille;

public class IA implements IPlayer{
	String name;
	String symbol;
	int level;
	
	
	public IA(String n, String s) {
		name=n;
		symbol=s;
		level=1;
	}
	
	public IA(String n, String s,int lvl) {
		name=n;
		symbol=s;
		level=lvl;
	}
	
	@Override
	public int chooseCell(Grille g) {
		int choice = -1;
		switch (level){
		case 1 :
			choice=CC1(g);
			break;
		case 2:
			choice=CC2(g);
			break;
			
		
		}
		if (choice==-1) {
			System.out.println("ERROR in chooseCell");
		}
		return choice;
	}

	
	public int CC1(Grille g) {
		Random rd = new Random();
		int col=-2;
		
		while (!g.isFree(col)) {
			col=-2;
			while ((col>8 || col<0)) {
				col = rd.nextInt(9);
			}
		}
		return col;
	}
	
	public int CC2(Grille g) {
		if (g.isFree(4)) {
			return 4;
		}
		else {
			/*
			int[] corners = {0,2,6,8};
			Random rd = new Random();
			for (int i=0; i<6;i++) { //Max try = 6
				int choice=rd.nextInt(4);
				
				if (g.isFree(corners[choice])){
					return choice;
				}
			}
			*/
			return CC1(g);
		}
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getSymbol() {
		return this.symbol;
	}

}
