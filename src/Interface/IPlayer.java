package Interface;

import gameEngine.Grille;

public interface IPlayer {
	int chooseCell(Grille g);
	
	String getName();
	
	String getSymbol();

    void setId(int i);

	int getId();

	void castPressed(int id);


}
