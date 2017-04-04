package driver;

import java.util.Scanner;

public class Menu {
	static private Game selectedGame;
	static private Athlete prediction;
	static private int initialized = 0;
	
	static public int optionSelect(){
		Scanner s = new Scanner(System.in);
		int option;
		System.out.print("Select option:");
		if(s.hasNextInt()){
			option = s.nextInt();
			return option;
		}else{
			return 0;
		}//if(s.hasNextInt())	
	}
	static public void displayError(){
		System.out.println("Error, that option is not available.");
		System.out.println("[press ENTER to continue]");
		Scanner s = new Scanner(System.in);
		if(s.hasNextLine()){
			s.nextLine();
			return;
		}		
	}
	
	/* Main Menu */
	
	static public void showMainMenu(){
		if(initialized == 0){
			System.out.println("\tWelcome to the Ozlympic Games!\n\n");
			initialized = 1;
		}
		System.out.println("\n\t Main Menu");
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
		System.out.println("3. Run game");
		System.out.println("4. Show final results");
		System.out.println("5. Show points of athletes");
		System.out.println("6. Exit\n");	
	}//static public int showMenu()
	
	static public void setSelectedGame(Game game){
		selectedGame = game;
	}
	
	static public Game getSelectedGame(){
		return selectedGame;
	}

	public static Athlete getPrediction() {
		return prediction;
	}

	public static void setPrediction(Game prediction) {
		prediction = prediction;
	}
	
	/* Game selection menu */
	
	static public void showGameMenu(Game[] games) {
		int i;
		System.out.println("\n\tSelect a game");
		System.out.println("********************************");
		for(i = 0; i < games.length; i++){
			System.out.println((i+1) + " - " + games[i].getID() + ", " + games[i].getName());
		}
		System.out.println(i + 1 + " - Return");
	}
	
	static public void selectGame(Game[] games){
		int subMenuOpt = optionSelect();
		if(subMenuOpt < 1 || subMenuOpt > games.length + 1){
			displayError();
		}else if(subMenuOpt == games.length + 1){
			return;
		}else{
			setSelectedGame(games[subMenuOpt - 1]);
		}
	}
	
	static public void showPredictionMenu(){
		int i, opt;
		selectedGame.showParticipants();
		System.out.println("Which athlete do you predict will win?");
		opt = optionSelect();
		if(opt < 0 || opt > selectedGame.getCompetitors().length + 1 ){
			displayError();
		}else if(opt == selectedGame.getCompetitors().length + 1){
			return;
		}else{
			Athlete[] temp = selectedGame.getCompetitors(); 
			prediction = temp[opt - 1];
		}
	}
	
	static public void showAthletePoints(Athlete[] athletes){
		int i;
		System.out.println("Current points for each athlete:");
		for(i = 0; i< athletes.length;i++){
			System.out.println(athletes[i].getName() + " - " + athletes[i].getPoints() + " points.");
		}
		System.out.println("[press ENTER to continue]");
		Scanner s = new Scanner(System.in);
		if(s.hasNextLine()){
			s.nextLine();
			return;
		}
	}
	
	static public void showPedestals(Athlete firstPlace, Athlete secondPlace, Athlete thirdPlace, Official off){
		System.out.println(off.getName() + " says: ");
		if(prediction != null){
			if (prediction.getID() == firstPlace.getID()){
				System.out.println("Your predicted athlete got first place! Congratulations!");
			}else if(prediction.getID() == secondPlace.getID()){
				System.out.println("Your predicted athlete got second place! Not bad");
			}else if(prediction.getID() == secondPlace.getID()){
				System.out.println("Your predicted athlete got third place! Not bad");
			}else{
				System.out.println("Sorry, your predicted athlete didn't do very well...");
			}
		}
		System.out.println("\n\n\t WINNERS \n\n");
		System.out.println("                         " + firstPlace.getName() + "                          ");
		System.out.println("                         ________________________                          ");
		System.out.println("                         |          1           |                          ");
		System.out.println("  " + secondPlace.getName() + "                                               ");
		System.out.println("_________________________|                      |                          ");
		System.out.println("|         2              |                      |                          ");
		System.out.println("                                                  " +  thirdPlace.getName() + "  ");
		System.out.println("|                        |                      |__________________________");
		System.out.println("|                        |                      |            3            |");
		System.out.println("\n[press ENTER to continue]");
		prediction = null;
		selectedGame = null;
		Scanner s = new Scanner(System.in);
		if(s.hasNextLine()){
			s.nextLine();
			return;
		}
	}
}
