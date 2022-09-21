package gameEngine;

import ui.WindowApp;

public class Launcher {
	public static void main(String[] args) {
		Menu menu = new Menu();
		//menu.affiche();
		WindowApp.launching(args);
	}
}
