package gameEngine;

import java.util.Random;
import java.util.Scanner;

import Interface.IPlayer;
import player.IA;
import player.Player;

public class Menu {

	public void affiche() {
		// TODO Auto-generated method stub
		System.out.println("1 - play");
		Scanner scanner = new Scanner(System.in);
		int choice = 12;
		while (choice<0 || choice>30) {
			choice = scanner.nextInt();
			System.out.println("ii = "+choice);
		}
		if (choice==1) {
			IA p1 = new IA("Josette","X");
			IA p2 = new IA("PauletteBot","O");
			
			Game game = new Game();
			game.setPlayers(p1,p2);
			game.start();
			game.getWinner();
		}
		else if(choice==12) {
			System.out.println(" IA TESTER");
			
			int levelA= 2;
			int levelB= 1;
			String nameA = "A lvl"+levelA;
			String nameB = "B lvl"+levelB;
			
			
			int nbGame=1000;
			float nbWinA=0;
			float nbWinB=0;
			float nbNull=0;
			for (int i=0;i<nbGame;i++) {
				IA A = new IA(nameA,"X",levelA);
				IA B = new IA(nameB,"O",levelB);
				Random rd = new Random();
				
				Game game = new Game();
				if (rd.nextInt(2)==0) {
					game.setPlayers(A,B);
				}
				else {
					game.setPlayers(B,A);
				}
				
				game.start();
				
				IPlayer winner = game.getWinner();
				if (winner == null) {
					nbNull+=1;
				}
				else if(winner == A) {
					nbWinA+=1;
				}
				else if(winner == B) {
					nbWinB+=1;
				}
			}
			System.out.println("\nWinrates:");
			System.out.println(nameA+": "+(nbWinA/nbGame*100)+"% ("+nbWinA+")");
			System.out.println(nameB+": "+(nbWinB/nbGame*100)+"% ("+nbWinB+")");
			System.out.println("Null: "+(nbNull/nbGame*100)+"% ("+nbNull+")");
		}
		
		
		
		
	}
	
	
}
