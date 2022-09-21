package ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
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
		primaryStage.show();
		
	} 
	

	// SCENE MENU
	public Scene menuScene(Stage primaryStage) {
		BorderPane bp = new BorderPane();
		VBox center = new VBox();
			Label title = new Label("Tic-Tac-Doigt-De-Pied");
			Button btnSolo = new Button("Solo");
			Button btnMultiplayer = new Button("Multiplayer");
			
			center.getChildren().addAll(title,btnSolo,btnMultiplayer);
		HBox left = new HBox();
		left.minWidth(200);
		
		HBox right = new HBox();
		right.minWidth(200);
		
		
		
		//bp.setTop(top);
		//bp.setBottom(bottom);
		bp.setLeft(left);			
		bp.setRight(right);
		bp.setCenter(center);
		return new Scene(bp);
	}
	
	
	
	public static void launching(String[] args) {
		WindowApp.launch(args);
	}


	
}
