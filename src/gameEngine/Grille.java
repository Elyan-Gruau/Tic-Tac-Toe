package gameEngine;

import player.Player;

public class Grille {
    int  size=3;
    int nbFull=0;
    String voidSymbol="·";
    String[][] grille= {
    		{"","",""},
    		{"","",""},
    		{"","",""}
    		};
	public void show() {
		System.out.println("   1 2 3"+
						   "\n +———————+");
		for (int i=0; i<size;i++) {
			String line = "";
    		for (int j=0;j<size;j++) {
    			line+=grille[i][j]+" ";
    		}
    		System.out.println((i+1)+"| "+line+"|");
    	}
		System.out.println(" +———————+");
		
		
	}
    public Grille() {
    	for (int i=0; i<size;i++) {
    		for (int j=0;j<size;j++) {
    			this.grille[i][j]=voidSymbol;
    			
    		}
    		
    	}
    }
    public boolean isFull() {
    	return nbFull==size*size;
    }
    public String getWinnerSymbol() {
    	//Spinner
    	if (grille[0][0] == grille[1][1] && grille[1][1] == grille[2][2] ) {//753
    		if (grille[1][1] != voidSymbol) {
    			return grille[1][1]; 
    		}
    		
    	}
    	if (grille[1][0] == grille[1][1] && grille[1][1] == grille[1][2] ) {//852
    		if (grille[1][1] != voidSymbol) {
    			return grille[1][1]; 
    		}
    	}
    	if (grille[2][0] == grille[1][1] && grille[1][1] == grille[0][2] ) {//951
    		if (grille[1][1] != voidSymbol) {
    			return grille[1][1]; 
    		}
    		
    	}
    	if (grille[2][1] == grille[1][1] && grille[1][1] == grille[0][1] ) {//654
    		if (grille[1][1] != voidSymbol) {
    			return grille[1][1];
    		}
    	}
    		 
    	for (int i=0; i<size;i++) {
    		if (grille[i][0] == grille[i][1] && grille[i][1] == grille[i][2] ) {//Vertical
    			if (grille[1][1] != voidSymbol) {
    				return grille[1][1]; 
    			}
        		
        	}
    	}
    	
    	for (int i=0; i<size;i++) {
    		if (grille[0][i] == grille[1][i] && grille[1][i] == grille[2][i] ) {//Horizontal
    			if (grille[1][i] != voidSymbol) {
    				return grille[1][i]; 
    			}
    		}
    	}
    	
    	
    	return "";
    }
    
    public void put(int[] choices,String symbol) {
    	grille[choices[0]][choices[1]]=symbol;
    	nbFull++;
    }
	public boolean isFree(int col,int line) {
		return grille[col][line]==voidSymbol;
	}
	
}
