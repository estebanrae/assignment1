package driver;

public class SwimGame extends Game {

	public SwimGame(String gameStr) {
		super(gameStr);
	}

	@Override
	public void runGame(Athlete athl) {
		athl.compete();
	}

}
