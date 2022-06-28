package player;

import java.util.Scanner;

import Interface.IPlayer;
import gameEngine.Grille;

public class Player implements IPlayer {
	String name;
	String symbol;
	public Player(String n, String s) {
		name=n;
		symbol=s;
	}
	@Override
	public int chooseCell(Grille g) {
		Scanner sc = new Scanner(System.in);
		boolean free = false;
		while ( !free) {
			int choice = -1;
			while (choice<1 || choice>9)  {
				System.out.println("Choose cell:\n>");
				choice = sc.nextInt();
			}
			
			if (g.isFree(choice-1)) {
				
				return choice-1;
				
			}
			else {
				System.out.println(choice+" is already used");
			}
		}
		return -1;
		
		
		
		
	}
	@Override
	public String getName() {
		return this.name;
	}
	public String getSymbol() {
		return this.symbol;
	}
	
}
