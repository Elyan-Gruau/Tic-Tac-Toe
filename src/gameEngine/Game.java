package gameEngine;

import Interface.IPlayer;
import player.Player;

public class Game {
	IPlayer player1;
	IPlayer player2;
	IPlayer winner;
	int turn=1;
	String winnerSymbol= "";
	
	public void start() {
		if (player1==null || player2==null) {
			System.out.println("NO PLAYERS");
			return;
		}
		else {
			System.out.println(player1.getName()+" VS. "+player2.getName());
		}
		Grille grille = new Grille();
		grille.show();
		
		while (winnerSymbol=="" && !grille.isFull() )  {
			System.out.println("TURN n°"+turn);

			grille.put(player1.chooseCell(grille), player1.getSymbol());
			grille.show();
			winnerSymbol = grille.getWinnerSymbol();
			
			if ( !grille.isFull()) {
				grille.put(player2.chooseCell(grille), player2.getSymbol());
				grille.show();
				winnerSymbol = grille.getWinnerSymbol();
			}
			
			turn++;
		}
		this.handleWinner();
	}
	
	
	public void handleWinner() {
		System.out.println("handling winner");
		if ( winnerSymbol ==player1.getSymbol())
			
			winner=player1;
		else if (winnerSymbol == player2.getSymbol()){
			winner=player2;
		}
		else if(winnerSymbol == winner.getSymbol()) {
			System.out.println("Match nulle");
		}
		else {
			System.out.println("The winner is "+winner.getName()+" "+winner.getSymbol());
		}
	}

	public void setPlayers(IPlayer p1, IPlayer p2) {
		
		player1 = p1;
		player2 = p2;
		
	}
	
	

}
