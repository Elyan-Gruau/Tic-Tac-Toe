package player;

import java.util.Random;

import Interface.IPlayer;
import gameEngine.Grille;

public class IA implements IPlayer{
	String name;
	String symbol;
	int level;
	
	
	public IA(String n, String s) {
		name=n;
		symbol=s;
		level=1;
	}
	
	public IA(String n, String s,int lvl) {
		name=n;
		symbol=s;
		level=lvl;
	}
	
	@Override
	public int chooseCell(Grille g) {
		int choice = -1;
		switch (level){
		case 1 ://Random
			choice=CC1(g);
			break;
		case 2: //CornerChooser
			choice=CC2(g);
			System.out.println("    2 choice:"+choice);
			break;
		case 3: // CCMiddle(g)
			choice=CC3(g);
			break;
		case 4:
			choice=CC4(g);
			break;
		case 5:
			choice=CC5(g);
			break;
		case 6:
			choice=CC6(g);
			break;
		case -1:
			choice=CC1Playable(g);
			break;
		case -2:
			choice=CC2Playable(g);
			break;
		case -3:
			choice=CC3Playble(g);
			break;
		case -4:
			choice=CC4Playable(g);
			break;
			
		}
		if (choice==-1) {
			//System.out.println("ERROR in chooseCell");
			System.out.println("-1 !!!!");
			choice=CCRandom(g);
		}
		if (!g.isFree(choice)) {
			System.out.println("ERROR CELL "+choice+" IS NOT FREE");
			return -1;
		}
			
		return choice;
	}

	
	private int CC4Playable(Grille g) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int CC3Playble(Grille g) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int CC2Playable(Grille g) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int CC1Playable(Grille g) {
		return CCRandom(g);
	}

	public int CC1(Grille g) {
		return CCRandom(g);
	}

	public int CC2(Grille g) {
		return CCCorners(g);
	}
	
	private int CC3(Grille g) {
		return  CCMiddle(g);
	}

	private int CC4(Grille g) {
		return CCLookForFinish(g);
	}
	
	private int CC5(Grille g) {
		int choice = CCLookForDefense(g);
		if (choice == -1){
			return CCMiddle(g);
		}
		return choice;
	}
	
	private int CC6(Grille g) {
		int choice = CCLookForFinish(g);
		if (choice == -1) {
			choice = CCLookForDefense(g);
			if (choice == -1) {
				choice=CCMiddle(g);
				if (choice==-1) {
					choice=CCCorners(g);
					System.out.println("CCCorners "+choice);
					if(choice==-1) {
						choice=CCRandom(g);
					}
				}
			}
		}
		return choice;
	}
	
	private int CC7(Grille g) {
		return -1;
	}
	
	private int CC8(Grille g) {
		return -1;
	}
	
	
	
	
	//---------------------------------------------------
	
	public int CCLookForFinish(Grille gr) {
		/*
		 * 0 1 2
		 * 3 4 5
		 * 6 7 8
		 */
		
		String[] g = gr.getGrille();
		String voidSymbol = gr.getVoidSymbol();
		int[] j = {0,3,6};//Horizontal checking 
		for (int i:j) {
			if(g[i] == symbol && g[i] == g[i+2] && g[i+1]== voidSymbol) { // Hole in the middle
				return i+1;
			}
			
			if (g[i+1] == symbol && g[i+1] == g[i+2] && g[i] == voidSymbol ) {// Les deux premiers
				return i;
			}
			if (g[i] == symbol && g[i] == g[i+1] && g[i+2] == voidSymbol) {// Les deux derniers
				return i+2;
			}
		
		}
		for (int i=0; i<gr.getSize();i++) {//Vertical checking
			if ( g[i] == symbol && g[i] == g[i+6] && g[i+3] == voidSymbol) { // Hole in the middle
				return i+3;
			}
			if (g[i]==symbol && g[i]==g[i+3] && g[i+6] == voidSymbol){// Les deux premiers
				return i+6;
			}
			if (g[i+3] == symbol && g[i+3]==g[i+6] && g[i]==voidSymbol){// Les deux derniers
				return i;
			}
		}
		// Diagonales8
		if (g[0] == symbol && g[0] == g[8] && g[4] == voidSymbol) {
			return 4;
		}
		if (g[4] == symbol && g[4] == g[8] && g[0] == voidSymbol) {
			return 0;
		}
		if (g[0] == symbol && g[0] == g[4] && g[8] == voidSymbol) {
			return 8;
		}
		if (g[2] == symbol && g[2] == g[6] && g[4] == voidSymbol) {
			return 4;
		}
		if (g[4] == symbol && g[4] == g[6]&& g[2] == voidSymbol) {
			return 2;
		}
		if (g[2]== symbol && g[2]==g[4] && g[6]== voidSymbol) {
			return 6;
		}
		
		
		
		return -1;
	}
	
	public int CCLookForDefense(Grille gr) {
		/*
		 * 0 1 2
		 * 3 4 5
		 * 6 7 8
		 */
		
		String[] g = gr.getGrille();
		String voidSymbol = gr.getVoidSymbol();
		int[] j = {0,3,6};//Horizontal checking 
		for (int i:j) {
			if( isOpposedSymbol(g[i],voidSymbol) && g[i] == g[i+2] && g[i+1]== voidSymbol) { // Hole in the middle
				return i+1;
			}
			
			if (isOpposedSymbol(g[i+1],voidSymbol) && g[i+1] == g[i+2] && g[i] == voidSymbol ) {// Les deux premiers
				return i;
			}
			if (isOpposedSymbol(g[i],voidSymbol)  && g[i] == g[i+1] && g[i+2] == voidSymbol) {// Les deux derniers
				return i+2;
			}
		
		}
		for (int i=0; i<gr.getSize();i++) {//Vertical checking
			if ( isOpposedSymbol(g[i],voidSymbol) && g[i] == g[i+6] && g[i+3] == voidSymbol) { // Hole in the middle
				return i+3;
			}
			if (isOpposedSymbol(g[i],voidSymbol) && g[i]==g[i+3] && g[i+6] == voidSymbol){// Les deux premiers
				return i+6;
			}
			if (isOpposedSymbol(g[i+3],voidSymbol) && g[i+3]==g[i+6] && g[i]==voidSymbol){// Les deux derniers
				return i;
			}
		}
		// Diagonales8
		if (isOpposedSymbol(g[0],voidSymbol) && g[0] == g[8] && g[4] == voidSymbol) {
			return 4;
		}
		if (isOpposedSymbol(g[4],voidSymbol) && g[4] == g[8] && g[0] == voidSymbol) {
			return 0;
		}
		if (isOpposedSymbol(g[0],voidSymbol) && g[0] == g[4] && g[8] == voidSymbol) {
			return 8;
		}
		if (isOpposedSymbol(g[2],voidSymbol) && g[2] == g[6] && g[4] == voidSymbol) {
			return 4;
		}
		if (isOpposedSymbol(g[4],voidSymbol) && g[4] == g[6]&& g[2] == voidSymbol) {
			return 2;
		}
		if (isOpposedSymbol(g[2],voidSymbol) && g[2]==g[4] && g[6]== voidSymbol) {
			return 6;
		}
		return -1;
	}
	public int CCRandom(Grille g) {
		Random rd = new Random();
		int col=-2;
		
		while (!g.isFree(col)) {
			col=-2;
			while ((col>8 || col<0)) {
				col = rd.nextInt(9);
			}
		}
		return col;
	}
	
	public int CCCorners(Grille g) {
		
		int[] corners = {0,2,6,8};
		Random rd = new Random();
		for (int i=0; i<15;i++) { //Max try = 10
			int choice=rd.nextInt(4);
			
			if (g.isFree(corners[choice])){
				return corners[choice];
			}
		}
		return -1;
	}
	
	public int CCMiddle(Grille g) {
		if (g.isFree(4)) {
			return 4;
		}
		else {
			return -1;
		}
	}
	
	
	// -------------------------- Tools
	public boolean isOpposedSymbol(String cell,String voidSymbol) {
		return (cell!= voidSymbol && cell!=symbol);
	}
	//--------------------------------------------------- Getters
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getSymbol() {
		return this.symbol;
	}

}
