/**
 * Class Menu: This class contains the main displays that will be used for the CLI program.
 * It also contains static variables defining the selected game and the selected prediction
 * for said game.
 * 
 * @version		1.0 28 MAR 2017
 * @author		Esteban Ramírez
 */

package driver;

import java.util.Scanner;

public class Menu {
	static private Game selectedGame;
	static private Athlete prediction;
	static private int initialized = 0;
	/**
	 * Lets the user select an option using a Scanner object. The option must be strictly an integer.
	 * @return
	 */
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
	/**
	 * Displays an error in the selected option.
	 */
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
	
	/**
	 * Displays the main menu for the user, in which they will be shown the current game selected
	 * and the prediction made, if any. Through this menu the users will be able to select
	 * to run the current game, show results or show points, as well as exit the game. 
	 */
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
	
	/**
	 * Accessor for selectedGame variable
	 * @param game
	 */
	static public void setSelectedGame(Game game){
		selectedGame = game;
	}
	/**
	 * Mutator for selectedGame variable
	 * @return
	 */
	static public Game getSelectedGame(){
		return selectedGame;
	}
	/**
	 * Accessor for prediction variable
	 * @return
	 */
	public static Athlete getPrediction() {
		return prediction;
	}
	/**
	 * Mutator for prediction variable
	 * @param prediction
	 */
	public static void setPrediction(Athlete prediction) {
		Menu.prediction = prediction;
	}
	
	/* Game selection menu */
	
	/**
	 * Shows the user the possible options they can choose. The user is also given the option to
	 * return to the main menu.
	 * @param games
	 * 		contains all possible games.
	 */
	static public void showGameMenu(Game[] games) {
		int i;
		System.out.println("\n\tSelect a game");
		System.out.println("********************************");
		for(i = 0; i < games.length; i++){
			System.out.println((i+1) + " - " + games[i].getID() + ", " + games[i].getName());
		}
		System.out.println(i + 1 + " - Return");
	}
	/**
	 * This method is an extension of the selectedGame Mutator, as its main function is to set 
	 * said variable. It uses optionSelect method to get the user's selection and set it as the
	 * current game. the current prediction is set to null. 
	 * @param games
	 * 		the array containing all game objects.
	 */
	static public void selectGame(Game[] games){
		int subMenuOpt = optionSelect();
		if(subMenuOpt < 1 || subMenuOpt > games.length + 1){
			displayError();
		}else if(subMenuOpt == games.length + 1){
			return;
		}else{
			setPrediction(null);
			setSelectedGame(games[subMenuOpt - 1]);
		}
	}
	
	/* Prediction Menu */
	/**
	 * Displays the list of all participants in the current game, and asks the user to choose a 
	 * predicted winner. An option to return to the main menu is also displayed.
	 */
	static public void showPredictionMenu(){
		int i, opt;
		for(i = 0; i < selectedGame.getCompetitors().length; i++){
			System.out.println((i+1) + " - " + selectedGame.getCompetitors()[i].getName());
		}
		System.out.println(i + 1 + " - Return");
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
	/**
	 * Shows a list of all ponts achieved for every athlete in the game. 
	 * @param athletes
	 */
	static public void showAthletePoints(Athlete[] athletes){
		int i;
		System.out.println("\n\tPOINTS PER ATHLETE\n");
		for(i = 0; i< athletes.length;i++){
			if(athletes[i].getPoints() == 1){
				System.out.println(athletes[i].getName() + " - " + athletes[i].getPoints() + " point.");
			}else{
				System.out.println(athletes[i].getName() + " - " + athletes[i].getPoints() + " points.");
			}
		}
		System.out.println("[press ENTER to continue]");
		Scanner s = new Scanner(System.in);
		if(s.hasNextLine()){
			s.nextLine();
			return;
		}
	}
	/**
	 * Shows the winners of the current game after it has ran. After the winners have been displayed
	 * the selectedGame and prediction are reset (null).
	 * @param firstPlace
	 * 		Athlete object containing the first place of the race
	 * @param secondPlace
	 * 		Athlete object containing the second place of the race
	 * @param thirdPlace
	 * 		Athlete object containing the third place of the race
	 * @param off
	 * 		Official of current game
	 */
	static public void showPedestals(Athlete firstPlace, Athlete secondPlace, Athlete thirdPlace, Official off){
		if(prediction != null){
			System.out.println(off.getName() + " says: ");
			if (prediction.getID() == firstPlace.getID()){
				System.out.println("Your predicted athlete got first place! Congratulations!");
			}else if(prediction.getID() == secondPlace.getID()){
				System.out.println("Your predicted athlete got second place! Not bad");
			}else if(prediction.getID() == thirdPlace.getID()){
				System.out.println("Your predicted athlete got third place! Not bad");
			}else{
				System.out.println("Sorry, your predicted athlete didn't do very well...");
			}
		}
		System.out.println("\n\n\t\t WINNERS \n\n");
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
	/**
	 * Displays an error indicating there is no currently selected game.
	 */
	static public void noSelectedGame(){
		System.out.println("Please select a game to run");
		System.out.println("[press ENTER to continue]");
		Scanner s = new Scanner(System.in);
		if(s.hasNextLine()){
			s.nextLine();
			return;
		}
	}
	/**
	 * Shows the results of all games, including the officials. 
	 * @param games
	 */
	static public void showAllGames(Game[] games){
		int i, j;
		System.out.println("\n\tGAME RESULTS");
		System.out.println("********************************\n");
		for(i = 0; i < games.length; i++){
			System.out.println("\n" + games[i].getName() + ", officiated by " + games[i].getOfficial().getName());
			if(games[i].getHasRun() == 1){
				System.out.println("\tPlace  |  Name");
				for(j = 0; j < games[i].getCompetitors().length; j++){
					System.out.println("\t" + (j + 1) + "      |" + games[i].getCompetitors()[j].getName());
				}
			}else{
				System.out.println("\t--Game hasn't run yet.--");
			}
		}
		System.out.println("[press ENTER to continue]");
		Scanner s = new Scanner(System.in);
		if(s.hasNextLine()){
			s.nextLine();
			return;
		}
		
	}
}
