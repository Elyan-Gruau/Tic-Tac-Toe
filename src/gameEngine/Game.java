package gameEngine;

import player.Player;

public class Game {
	Player player1;
	Player player2;
	Player winner;
	int turn=0;
	
	public void start() {
		// TODO Auto-generated method stub
		if (player1==null || player2==null) {
			System.out.println("NO PLAYERS");
			return;
		}
		else {
			System.out.println(player1.getName()+" VS. "+player2.getName());
		}
		Grille grille = new Grille();
		grille.show();
		
	}

	public void setPlayers(Player p1, Player p2) {
		// TODO Auto-generated method stub
		player1 = p1;
		player2 = p2;
		
	}
	
	

}
