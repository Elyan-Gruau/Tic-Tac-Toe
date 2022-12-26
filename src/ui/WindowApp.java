package ui;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import gameEngine.EGameStates;
import gameEngine.Game;
import gameEngine.Grille;
import gameEngine.Menu;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import player.IA;
import player.Player;
import java.util.Random;

public class WindowApp extends Application{
	String genFont  = "Arial";
	int genFontSize = 15;
	int width       = 1280;
	int height      = 720;
	Game currentGame;
	Label labGameState;
	GridPane gp;
	private ArrayList<Button> board;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Tic tac toe");
		primaryStage.setMinWidth(width);
		primaryStage.setMinHeight(height);
	    // primaryStage.getIcons().add(new Image(getClass().getResource("../assets/textures/TTT_logo.png").toExternalForm()));
		primaryStage.setScene(menuScene(primaryStage));
		
		//Menu menu = new Menu();
		primaryStage.show();

		final long startNanoTime = System.nanoTime();
		new AnimationTimer()
		{
			public void handle(long currentNanoTime)
			{
				double t = (currentNanoTime - startNanoTime) / 1000000000.0;
				try {
					Thread.sleep(14);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				loop();
			}
		}.start();
	}


	private void loop(){
		if (this.currentGame == null){
			//System.out.println("pas de jeu en cours.");
		}
		else {
			//System.out.println("jeu en cours");
			updateBackground();
			labGameState.setText(GameStateMessages.get(currentGame.getState()));
			switch (currentGame.getState()){
				case startingGame -> {

				}
				case p1Choosed,p2Choosed -> {
					updateGrille();
				}
				case endGame -> {

				}
			}

		}
	}

	private void updateGrille() {
		Grille currentGrille = currentGame.getGrille();
		for (int i = 0; i < 9;i++){
			board.get(i).setText(currentGrille.getGrille()[i]);
		}
	}

	private void updateBackground() {
		if (currentGame.getCurrentPlayer() == null){
			gp.setBackground(Background.fill(Color.rgb(40, 40, 89)));
		}
		else if (currentGame.getCurrentPlayer().getId() == 1){
			gp.setBackground(Background.fill(Color.rgb(89, 40, 45)));
		}
		else {
			gp.setBackground(Background.fill(Color.rgb(40, 40, 45)));
		}
	}


	// SCENE MENU
	public Scene menuScene(Stage primaryStage) {
		BorderPane bp = new BorderPane();

			//Center -----------------------------------------------------------
			this.gp = new GridPane();
				this.board = new ArrayList<>();
				for (int i=0;i<9;i++) {
					board.add(buttonMaker(i));
					//board.get(i).setDisable(true);
				}
				gp.add(board.get(0), 0, 0);
				gp.add(board.get(1), 1, 0);
				gp.add(board.get(2), 2, 0);
				gp.add(board.get(3), 0, 1);
				gp.add(board.get(4), 1, 1);
				gp.add(board.get(5), 2, 1);
				gp.add(board.get(6), 0, 2);
				gp.add(board.get(7), 1, 2);
				gp.add(board.get(8), 2, 2);
				
				gp.setPadding(new Insets(20));
			    gp.setHgap(15);
			    gp.setVgap(15);
			    gp.setAlignment(Pos.CENTER);
			    gp.setBackground(Background.fill(Color.rgb(40, 40, 45)));
			
		// TOP -----------------------------------------------------------
		HBox top = new HBox();
			Label title = new Label("Tic-Tac-Toe");
			title.setTextFill(Color.rgb(240, 240, 245));
			top.setAlignment(Pos.CENTER);

	title.setFont(Font.font("Arial",50));
			top.getChildren().add(title);
			top.setBackground(Background.fill(Color.rgb(30, 30, 35)));
			
		// LEFT -----------------------------------------------------------
		VBox left = new VBox();
			ToggleGroup rd = new ToggleGroup();
				RadioButton btnSolo = new RadioButton("Solo");
				RadioButton btnMulti = new RadioButton("Duo");
				btnSolo.setToggleGroup(rd);
				btnMulti.setToggleGroup(rd);
				rd.selectToggle(btnSolo);
				
			Label labP1Name = new  Label("P1 Name");
			TextField p1Name = textFieldMaker();
			
			Label labP2Name = new  Label("P2 Name");
			TextField p2Name = textFieldMaker();
			
			Label labBotName = new  Label("Bot Name");
			TextField botName = textFieldMaker();

			Label lb3 = new Label("Bot level");
			Slider botLvl = new Slider();

			Button btnStart = new Button("Start");
			btnStart.setOnAction((action) -> {
				createGame(p1Name,p2Name,botName,botLvl,btnSolo,rd);
					});

			left.setBackground(Background.fill(Color.ALICEBLUE));
			left.getChildren().addAll(btnSolo,btnMulti,labP1Name,p1Name,labP2Name,p2Name,labBotName,botName,lb3,botLvl,btnStart);
			left.setAlignment(Pos.CENTER);
			left.setMinWidth(200);
			//Random on off
			//Slider Bot Lvl
			//MenuSelect de Strat�gie
			//Nom Player 1
			//Nom Player 2
			//Nom Bot
			//Start
		
			
		//Right -----------------------------------------------------------
		HBox right = new HBox();
			right.minWidth(200);
			right.minHeight(1500);
			Label labVs = new Label("Pedro X VS. Michel o");
			this.labGameState = new Label("none.");
			right.getChildren().addAll(labVs,labGameState);
			right.setBackground(Background.fill(Color.ALICEBLUE));

		
		

	    
		
		
		
		bp.setTop(top);
		//bp.setBottom(bottom);
		bp.setLeft(left);			
		bp.setRight(right);
		bp.setCenter(gp);
		return new Scene(bp);
	}
	
	private TextField textFieldMaker() {
		TextField tc = new TextField();
		tc.setMinWidth(20);
		return tc;
	}
	
	private  Button buttonMaker(int id) {
		Button btn = new Button(" ");
		btn.setMinHeight(100);
		btn.setMinWidth(100);
		btn.setOnAction((action)-> {
			if (currentGame!=null && currentGame.getCurrentPlayer().getClass() == Player.class) {
				System.out.println("button "+id+" clicked");
				currentGame.setPressedButton(id);
			}

		});
		return btn;
	}
	
	public static void launching(String[] args) {
		WindowApp.launch(args);
	}
	
	private void gameHandler() {
		
	}

	private void createGame(TextField p1Name, TextField p2Name,TextField botName,Slider botLevel, RadioButton btnSolo,ToggleGroup rd){
		Game game = new Game();
		String player1Name = "a";
		String player2Name = "b";
		String botNameText = "Jim";
		if (p1Name.getText().length()>0) {
			player1Name = p1Name.getText();
		}
		if (p2Name.getText().length()>0) {
			player2Name = p2Name.getText();
		}
		if (botName.getText().length()>0) {
			botNameText = botName.getText();
		}



		Player p1 = new Player(player1Name,"x");
		Random r = new Random();
		if (rd.getSelectedToggle()==btnSolo) {
			System.out.println("solo");
			//int IAlvl =
			IA p2 = new IA(botNameText,"o",1);

			if (r.nextInt(2)==0) {
				game.setPlayers(p1,p2);
			}
			else {
				game.setPlayers(p2,p1);
			}
		}

		else {
			System.out.println("multi");
			Player p2 = new Player(player2Name,"o");
			if (r.nextInt(2)==0) {
				game.setPlayers(p1,p2);
			}
			else {
				game.setPlayers(p2,p1);
			}
		}


		System.out.println("new game created: "+game.getPlayer1().getName()+" vs "+game.getPlayer2().getName());
		this.currentGame = game;

		game.start();
		//game.getWinner();


	}


	
}
