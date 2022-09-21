package ui;

import gameEngine.Menu;
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

public class WindowApp extends Application{
	String genFont  = "Arial";
	int genFontSize = 15;
	int width       = 1280;
	int height      = 720;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Tic tac toe");
		primaryStage.setMinWidth(width);
		primaryStage.setMinHeight(height);
	    // primaryStage.getIcons().add(new Image(getClass().getResource("../assets/textures/TTT_logo.png").toExternalForm()));
		primaryStage.setScene(menuScene(primaryStage));
		
		//Menu menu = new Menu();
		primaryStage.show();

	} 
	

	// SCENE MENU
	public Scene menuScene(Stage primaryStage) {
		BorderPane bp = new BorderPane();
		VBox center = new VBox();
			center.setMinWidth(100);
			center.setAlignment(Pos.CENTER);
			
		HBox top = new HBox();
			Label title = new Label("Tic-Tac-Toe");
			title.setTextFill(Color.rgb(240, 240, 245));
			top.setAlignment(Pos.CENTER);
			title.setFont(Font.font("Arial",50));
			top.getChildren().add(title);
			top.setBackground(Background.fill(Color.rgb(30, 30, 35)));
			
		
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
			
			Button btnStart = new Button("Start");
			Label lb3 = new Label("Bot level");
			Slider botLvl = new Slider();
			left.setBackground(Background.fill(Color.ALICEBLUE));
			left.getChildren().addAll(btnSolo,btnMulti,labP1Name,p1Name,labP2Name,p2Name,labBotName,botName,lb3,botLvl,btnStart);
			left.setAlignment(Pos.CENTER);
			left.setMinWidth(200);
			//Random on off
			//Slider Bot Lvl
			//MenuSelect de Stratégie
			//Nom Player 1
			//Nom Player 2
			//Nom Bot
			//Start
		
			
		HBox right = new HBox();
			right.minWidth(200);
			right.minHeight(1500);
			right.setBackground(Background.fill(Color.ALICEBLUE));
		
		
		GridPane gp = new GridPane();
			Button btn1 = buttonMaker();
			Button btn2 = buttonMaker();
			Button btn3 = buttonMaker();
			Button btn4 = buttonMaker();
			Button btn5 = buttonMaker();
			Button btn6 = buttonMaker();
			Button btn7 = buttonMaker();
			Button btn8 = buttonMaker();
			Button btn9 = buttonMaker();
			gp.add(btn1, 0, 0);
			gp.add(btn2, 1, 0);
			gp.add(btn3, 2, 0);
			gp.add(btn4, 0, 1);
			gp.add(btn5, 1, 1);
			gp.add(btn6, 2, 1);
			gp.add(btn7, 0, 2);
			gp.add(btn8, 1, 2);
			gp.add(btn9, 2, 2);
			
			
			
			gp.setPadding(new Insets(20));
		    gp.setHgap(15);
		    gp.setVgap(15);
		    gp.setAlignment(Pos.CENTER);
		    gp.setBackground(Background.fill(Color.rgb(40, 40, 45)));
	    
		//t.getChildren().add(t);
		
		
		bp.setTop(top);
		//bp.setBottom(bottom);
		bp.setLeft(left);			
		//bp.setRight(right);
		bp.setCenter(gp);
		return new Scene(bp);
	}
	
	private TextField textFieldMaker() {
		TextField tc = new TextField();
		tc.setMinWidth(20);
		return tc;
	}
	
	private Button buttonMaker() {
		Button btn = new Button(" ");
		btn.setMinHeight(100);
		btn.setMinWidth(100);
		return btn;
	}
	
	public static void launching(String[] args) {
		WindowApp.launch(args);
	}


	
}
