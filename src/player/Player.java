package player;

import java.util.Scanner;

import Interface.IPlayer;
import gameEngine.Grille;

public class Player implements IPlayer {
	String name;
	String symbol;
	Boolean terminalDisplay=false;

	Boolean choosed=false;
	int choice = -2;
	int id;
	public Player(String n, String s) {
		name=n;
		symbol=s;
	}
	@Override
	public int chooseCell(Grille g) {

		Scanner sc = new Scanner(System.in);
		boolean free = false;
		while ( !free) {
			int c = -2;
			/*
			while (choice<1 || choice>9)  {
				System.out.println("Choose cell:\n>");
				choice = sc.nextInt();
			}
			 */

			c = waitForPress(10);

				
			if (g.isFree(c)) {
				return c;
					
			}
			else {
				System.out.println(choice+" is already used");
			}

		}
		System.out.println("ERROR!");
		return -1;
		
		
		
		
	}
	@Override
	public String getName() {
		return this.name;
	}
	public String getSymbol() {
		return this.symbol;
	}

	@Override
	public void setId(int i) {
		this.id = i;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public void castPressed(int id) {
		choice = id;
	}

	public int waitForPress(int milisecs){

		while (choice==-2){

			try {
				Thread.sleep(14);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		return choice;
	}

}
