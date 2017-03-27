package driver;

public abstract class Game {
	private String ID;
	private Official official;
	
	public abstract void runGame();
	
	public Game(String gameStr){
		
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Official getOfficial() {
		return official;
	}

	public void setOfficial(Official official) {
		this.official = official;
	}
}
