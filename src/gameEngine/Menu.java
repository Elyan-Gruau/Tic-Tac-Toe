package gameEngine;

import java.util.Scanner;

import player.IA;
import player.Player;

public class Menu {

	public void affiche() {
		// TODO Auto-generated method stub
		System.out.println("1 - play");
		Scanner scanner = new Scanner(System.in);
		int choice = 1;
		while (choice<0 || choice>2) {
			choice = scanner.nextInt();
			System.out.println("ii = "+choice);
		}
		if (choice==1) {
			Player p1 = new Player("Josette","X");
			IA p2 = new IA("Paulette","O");
			
			Game game = new Game();
			game.setPlayers(p1,p2);
			game.start();
		}
		
		
		
		
	}
	
	
}
