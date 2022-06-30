package gameEngine;

import java.util.Random;
import java.util.Scanner;

import Interface.IPlayer;
import player.IA;
import player.Player;
import player.Stats;

public class Menu {

	public void affiche() {
		// TODO Auto-generated method stub
		System.out.println("1 - play");
		Scanner scanner = new Scanner(System.in);
		int choice = -1;
		while (choice<0 || choice>30) {
			choice = scanner.nextInt();
			System.out.println("ii = "+choice);
		}
		if (choice==1) {
			Random rd = new Random();
			Player p1 = new Player("Elyan","x");
			IA p2 = new IA("PauletteBot","o",6);
			
			Game game = new Game();
			if (rd.nextInt(2)==0) {
				game.setPlayers(p1,p2);
			}
			else {
				game.setPlayers(p2,p1);
			}
			game.start();
			game.getWinner();
		}
		else if(choice==12) {
			System.out.println(" IA TESTER");
			
			int levelA= 6;
			int levelB= 1;
			String nameA = "A lvl"+levelA;
			String nameB = "B lvl"+levelB;
			
			
			int nbGame=1000;
			//Stats StatsA = new Stats();
			//Stats StatsB = new Stats();
			float nbWinA=0;
			float nbWinAF=0;
			float nbWinAL=0;
			float nbWinB=0;
			float nbWinBF=0;
			float nbWinBL=0;
			float nbNull=0;
			boolean AFirst;
			for (int i=0;i<nbGame;i++) {
				IA A = new IA(nameA,"x",levelA);
				IA B = new IA(nameB,"o",levelB);
				Random rd = new Random();
				
				Game game = new Game();
				if (rd.nextInt(2)==0) {
					game.setPlayers(A,B);
					AFirst=true;
				}
				else {
					game.setPlayers(B,A);
					AFirst=false;
				}
				
				game.start();
				
				IPlayer winner = game.getWinner();
				if (winner == null) {
					nbNull+=1;
				}
				else if(winner == A) {
					nbWinA+=1;
					if (AFirst) {
						nbWinAF++;
					}
					else {
						nbWinAL++;
					}
				}
				else if(winner == B) {
					nbWinB+=1;
					if (!AFirst) {
						nbWinBF++;
					}
					else {
						nbWinBL++;
					}
				}
			}
			System.out.println("---------------- STATS ---------------");
			System.out.println("\nWinrates:");
			System.out.println(nameA+": "+(nbWinA/nbGame*100)+"% ("+nbWinA+") First "+(nbWinAF/nbGame*100)+"% Last "+(nbWinAL/nbGame*100)+"%");
			System.out.println(nameB+": "+(nbWinB/nbGame*100)+"% ("+nbWinB+") First "+(nbWinBF/nbGame*100)+"% Last "+(nbWinBL/nbGame*100)+"%");
			System.out.println("Null: "+(nbNull/nbGame*100)+"% ("+nbNull+")");
		}
		
		
		
		
	}
	
	
}
