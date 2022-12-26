package gameEngine;

import Interface.IPlayer;
import player.Player;

import java.util.ArrayList;

public class Game {
	IPlayer player1;
	IPlayer player2;
	IPlayer winner;
	int turn=1;
	String winnerSymbol= "";
	String gameStateMessage;
	Grille grille;
	IPlayer currentPlayer = player1;
	EGameStates gameState;
	int pressedButton = -1;
	
	public void start() {
		if (player1==null || player2==null) {
			System.out.println("NO PLAYERS");
			return;
		}
		else {
			System.out.println(player1.getName()+" VS. "+player2.getName());
			System.out.println("Starting with "+player1.getName());
		}
		this.grille = new Grille();
		grille.update();//grille.show();
		while (winnerSymbol=="" && !grille.isFull() )  {
			System.out.println("\n------------- TURN n°"+turn+" --------------");
			if (!grille.isFull() && winnerSymbol=="") {
				currentPlayer = player1;
				System.out.println(player1.getName()+" -> "+player1.getSymbol());
				gameState = EGameStates.p1Choosing;
				//Wait for pressed button
				int c = player1.chooseCell(grille);
				System.out.println(c);
				grille.put(c, player1.getSymbol());

				gameState = EGameStates.p1Choosed;
				if (player2.getClass() == Player.class) {
					//grille.showWithHelp();

				}
				else {
					//grille.show();
				}
				winnerSymbol = grille.getWinnerSymbol();
			}
			
			if ( !grille.isFull() && winnerSymbol=="") {
				currentPlayer = player2;
				System.out.println(player2.getName()+" -> "+player2.getSymbol());
				gameState = EGameStates.p2Choosing;
				int c = player2.chooseCell(grille);
				System.out.println(c);
				grille.put(c, player2.getSymbol());
				gameState = EGameStates.p2Choosed;
				if (player1.getClass() == Player.class) {
					//grille.showWithHelp();
				}
				else {
					//grille.show();
				}
				
				winnerSymbol = grille.getWinnerSymbol();
			}
			
			turn++;
		}
		//System.out.println(winnerSymbol+" "+grille.isFull());
		this.handleWinner();
	}
	
	
	public void handleWinner() {
		//System.out.println("handling winner");
		if ( winnerSymbol == player1.getSymbol()) {
			winner=player1;
			//showWinner(player1);
		}
		else if (winnerSymbol == player2.getSymbol()){
			winner=player2;
			//showWinner(player2);
		}
		else {
			System.out.println("Match nul");
			winner = null;
		}

		gameState = EGameStates.endGame;
	}
	
	public static void showWinner(IPlayer p) {
		String fill = "�";
		fill.repeat(p.getName().length());
		System.out.println("\n+��������������"+fill+"����������+");
		System.out.println("|The winner is "+p.getName()+" ("+p.getSymbol()+") |");
		System.out.println("+��������������"+fill+"����������+\n\n\n");
	}
	
	public IPlayer getWinner() {
		return this.winner;
	}
	
	public void setPlayers(IPlayer p1, IPlayer p2) {

		player1 = p1;
		player2 = p2;
		player1.setId(1);
		player2.setId(2);
		
	}


	public IPlayer getPlayer1() {
		return player1;
	}

	public IPlayer getPlayer2() {
		return 	player2;
	}

	public String getStateMessage() {
		return gameStateMessage;
	}

	public int getTurn() {
		return turn;
	}

	public Grille getGrille() {
		return grille;
	}


	public EGameStates getState() {
		return gameState;
	}


	public IPlayer getCurrentPlayer() {
		return currentPlayer;
	}

	public Game(){
		this.gameState = EGameStates.startingGame;

	}

	public void setPressedButton(int id) {
		pressedButton = id;
		this.currentPlayer.castPressed(id);
	}

	private void wait(int milisecs){
		try {
			Thread.sleep(milisecs);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
