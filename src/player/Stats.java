package player;

public class Stats {
	int wins=0;
	int winBeingFirst=0;
	int winBeingLast=0;
	
	public Stats() {
		
	}
	public int getWins() {
		return wins;
	}
	public void addtWins(int wins) {
		this.wins += wins;
	}
	public int getWinBeingFirst() {
		return winBeingFirst;
	}
	public void addWinBeingFirst(int winBeingFirst) {
		this.winBeingFirst += winBeingFirst;
	}
	public int getWinBeingLast() {
		return winBeingLast;
	}
	public void addWinBeingLast(int winBeingLast) {
		this.winBeingLast += winBeingLast;
	}
}
