package gameEngine;

public class Grille {
    int  size=3;
    String voidSymbol="e";
    String[][] grille= {
    		{"","",""},
    		{"","",""},
    		{"","",""}
    		};
	public void show() {
		
		for (int i=0; i<size;i++) {
			String line = "";
    		for (int j=0;j<size;j++) {
    			line+=grille[i][j];
    		}
    		System.out.println(line);
    	}
		
		
	}
    public Grille() {
    	for (int i=0; i<size;i++) {
    		for (int j=0;j<size;j++) {
    			this.grille[i][j]=voidSymbol;
    			
    		}
    		
    	}
    }

}
