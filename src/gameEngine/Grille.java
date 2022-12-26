package gameEngine;

import java.util.ArrayList;

import javafx.scene.control.Button;
import player.Player;

public class Grille {
    int  size=3;
    int nbFull=0;
    String voidSymbol="�";
    String[] grille= {"1","2","3","4","5","6","7","8","9"};
    ArrayList<Button> visualGrille = new ArrayList<>();
    
    
    public void update() {
    	for (int i=0;i<9;i++) {
    		
    		if (grille[i]==" ") {
    			visualGrille.get(i).setDisable(false);

    		}
    	}
    }
    
    public void addVisualBoard(ArrayList<Button> board) {
    	this.visualGrille = board;
    }
    
	
	
    public Grille() {
    	int[] j = {0,3,6};
    	for (int i:j) {
    		grille[i]=voidSymbol;
    		grille[i+1]=voidSymbol;
    		grille[i+2]=voidSymbol;    		
    	}
    	
    	
    }
    public boolean isFull() {
    	return nbFull==size*size;
    }
    public String getWinnerSymbol() {
    	//System.out.println("getting winner symbol");
    	/*
    	 * 0 1 2
    	 * 3 4 5
    	 * 6 7 8
    	 */
    	
    	
    	//Spinner
    	if (grille[0] == grille[4] && grille[4] == grille[8] ) {//753
    		if (grille[4] != voidSymbol) {
    			//System.out.println("1");
    			return grille[4]; 
    		}
    		
    	}
    	if (grille[1] == grille[4] && grille[4] == grille[7] ) {//852
    		if (grille[4] != voidSymbol) {
    			//System.out.println("2");
    			return grille[4]; 
    		}
    	}
    	if (grille[2] == grille[4] && grille[4] == grille[6] ) {//951
    		if (grille[4] != voidSymbol) {
    			//System.out.println("3");
    			return grille[4]; 
    		}
    		
    	}
    	if (grille[5] == grille[4] && grille[4] == grille[3] ) {//654
    		if (grille[4] != voidSymbol) {
    			//System.out.println("4");
    			return grille[4];
    		}
    	}
    	/*
    	 * 0 1 2
    	 * 3 4 5
    	 * 6 7 8
    	 */ 
    	for (int i=0; i<size;i++) { //Vertical
    		if (grille[i]==grille[i+3] && grille[i+3] == grille[i+6]) {
    			if (grille[i]!= voidSymbol) {
    				//System.out.println("5");
    				return grille[i];
    			}
    		}
    	}
    	int[] j = {0,3,6};
    	for (int i:j) {// horizontal
    		if (grille[i]==grille[i+1] && grille[i+1]==grille[i+2]) {
    			if (grille[i]!= voidSymbol) {
    				//System.out.println("6");
    				return grille[i];
    			}
    		}
    	}
    	
    	//System.out.println("done");
    	return "";
    }
    
    public void put(int choice,String symbol) {
    	grille[choice]=symbol;
    	nbFull++;
    }
	public boolean isFree(int i) {
		if (i<0 || i>8 ) {
			return false;
		}
		return grille[i]==voidSymbol;
	}
	
	public String getVoidSymbol() {
		return this.voidSymbol;
	}
	
	public String[] getGrille() {
		return this.grille;
	}
	public int getSize() {
		return this.size;
	}
}
