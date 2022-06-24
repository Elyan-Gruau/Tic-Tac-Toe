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
	public int[] chooseCell(Grille g) {
		Scanner sc = new Scanner(System.in);
		boolean free = false;
		while ( !free) {
			int choiceL = -1;
			int choiceC = -1;
			while (choiceC<1 || choiceC>3)  {
				System.out.println("Choose column:\n>");
				choiceC = sc.nextInt();
			}
			while (choiceL<1 || choiceL>3 ) {
				System.out.println("Choose line:\n>");
				choiceL = sc.nextInt();
			}
			if (g.isFree(choiceC, choiceL)) {
				int[] choices = {choiceL-1,choiceC-1};
				return choices;
				
			}
			else {
				System.out.println(choiceC+" "+choiceL+" is already used");
			}
		}
		return null;
		
		
		
	}
	@Override
	public String getName() {
		return this.name;
	}
	public String getSymbol() {
		return this.symbol;
	}
	
}
