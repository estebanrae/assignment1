package driver;

public class MainMenu {
	static private Game selectedGame;
	static private Game prediction;
	static public void showMenu(){
		System.out.println("\tWelcome to the Ozlympic Games!\n");
		System.out.println("********************************");
		if(selectedGame == null){
			System.out.println("No game selected ");
		}else{
			System.out.println("Game: " + selectedGame.getName());
			if(prediction != null){
				System.out.println("Predicted winner: " + prediction.getName());
			}
		}//if(selectedGame == "")
		System.out.println("********************************");
		System.out.println("1. Select a game to run");
		System.out.println("2. Predict winner of the game");
		System.out.println("1. Select a game to run");
		System.out.println("3. Run game");
		System.out.println("4. Show final results");
		System.out.println("5. Show points of athletes");
		System.out.println("6. Exit\n");	
	}//static public int showMenu()
	
	static public void setSelectedGame(Game game){
		selectedGame = game;
	}

	public static Game getPrediction() {
		return prediction;
	}

	public static void setPrediction(Game prediction) {
		MainMenu.prediction = prediction;
	}
	

}//public class MainMenu
