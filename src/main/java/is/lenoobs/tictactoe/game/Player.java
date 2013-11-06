package is.lenoobs.tictactoe.game;

public class Player {
	private String name;
	private int wins;
	private int losses;

	public Player() {
		name = "";
		wins = 0;
		losses = 0;
	}

	public String getName() {
		return name;
	}
	public int getWins() {
		return wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setName(String _name) {
		this.name = _name; 
	}
	public void setWins() {
		this.wins++;
	}
	public void setLosses() {
		this.losses++;
	}
}