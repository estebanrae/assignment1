/*
 * Class Driver: Handling of the main menu and initialization of games is performed here.
 * 
 * @version		1.0 27 MAR 2017
 * @author		Esteban Ramírez
 */
package driver;

public class Driver {
	private Athlete[] athletes;
	private Official[] officials;
	private Game[] games;
	
	/**
	 * Uses a loop to display the main menu, while the selected option is different from 6, which
	 * is the option to leave the program
	 * 
	 */
	
	public void mainMenu() {
		int menuOpt;
		do{
			Menu.showMainMenu();
			menuOpt = Menu.optionSelect();
			if(menuOpt == 1){
				Menu.showGameMenu(games);
				Menu.selectGame(games);			
			}else if(menuOpt ==2){
				if(Menu.getSelectedGame() != null){
					Menu.showPredictionMenu();
				}else{
					Menu.noSelectedGame();
				}
			}else if(menuOpt ==3){
				if(Menu.getSelectedGame() != null){
					Menu.getSelectedGame().runGame();
				}else{
					Menu.noSelectedGame();
				}
			}else if(menuOpt == 4){
				Menu.showAllGames(games);
			}else if(menuOpt ==5){
				this.sortAthletesByPoints();
				Menu.showAthletePoints(athletes);
			}else if(menuOpt != 6){
				Menu.displayError();
			}
		}while(menuOpt != 6);
		
	}
	/**
	 * Initializes the array of athletes by reading all files containing information on them,
	 * then storing them in the Driver object's athletes variable.
	 */
	public void initializeAthletes(){
		int i, swimmerLength,
			cycleLength, 
				sprinterLength,
				superAthleteLength;
		/* Initializing all athletes */
		String[] swimmersTxt= Reader.readFile("src/files/swimmers.txt");
		swimmerLength = Reader.lines;
		String[] cyclistsTxt= Reader.readFile("src/files/cyclists.txt");
		cycleLength = Reader.lines;
		String[] sprintersTxt= Reader.readFile("src/files/sprinters.txt");
		sprinterLength = Reader.lines;
		String[] superAthleteTxt= Reader.readFile("src/files/super_athletes.txt");
		superAthleteLength = Reader.lines;
		athletes = new Athlete[swimmerLength + cycleLength + sprinterLength + superAthleteLength];
		for (i = 0; i < swimmerLength; i++){
			athletes[i] = new Swimmer(swimmersTxt[i]);
		}
		for (i = 0; i < cycleLength; i++){
			athletes[i  + swimmerLength] = new Cyclist(cyclistsTxt[i]);
		}
		for (i = 0; i < sprinterLength; i++){
			athletes[i + cycleLength + swimmerLength] = new Sprinter(sprintersTxt[i]);
		}
		for (i = 0; i < superAthleteLength; i++){
			athletes[sprinterLength + cycleLength + swimmerLength + i] = new SuperAthlete(superAthleteTxt[i]);
		}
	}
	/**
	 * Initializes the array of officials by reading all files containing information on them,
	 * then storing them in the Driver object's officials variable.
	 */
	public void initializeOfficials(){
		/* Initializing officials */
		int i;
		String[] officialTxt= Reader.readFile("src/files/officials.txt");
		int officialLength = Reader.lines;
		officials = new Official[officialLength];
		for(i = 0; i< officialLength; i++){
			officials[i] = new Official(officialTxt[i]);
		}
	}
	/**
	 * Initializes the array of games by reading all files containing information on them,
	 * then storing them in the Driver object's games variable.
	 */
	public void initializeGames(){
		int swimGamesLength, 
		cycleGamesLength, 
		sprinterGamesLength, i;
		/* Initializing all games */
		String[] swimGamesTxt= Reader.readFile("src/files/swimgames.txt");
		swimGamesLength = Reader.lines;
		String[] cycleGamesTxt= Reader.readFile("src/files/cyclegames.txt");
		cycleGamesLength = Reader.lines;
		String[] sprinterGamesTxt= Reader.readFile("src/files/sprintergames.txt");
		sprinterGamesLength = Reader.lines;
		games = new Game[swimGamesLength + cycleGamesLength + sprinterGamesLength];
		for(i = 0; i< swimGamesLength; i++){
			games[i] = new SwimGame(swimGamesTxt[i], officials, athletes);
		}
		for(i = 0; i< cycleGamesLength; i++){
			games[swimGamesLength + i] = new CycleGame(cycleGamesTxt[i], officials, athletes);
		}
		for(i = 0; i< sprinterGamesLength; i++){
			games[swimGamesLength + cycleGamesLength + i] = new RunningGame(sprinterGamesTxt[i], officials, athletes);
		}	
	}
	/**
	 * This function is used to sort the array of athletes from most points to least points in the
	 * way: array[0] = athlete with most points, array[1] = athlete with second most points.
	 * This way we can see the results in an ordered fashion.
	 */
	public void sortAthletesByPoints(){
		boolean flag = true;
		int j;
		Athlete temp;
		while ( flag ){
			flag= false;   
			for( j=0;  j < athletes.length -1;  j++ ){
				if ( athletes[ j ].getPoints() < athletes[j+1].getPoints() ){
					temp = athletes[ j ]; 
					athletes[ j ] = athletes[ j+1 ];
					athletes[ j+1 ] = temp;
					flag = true;
				} 
			} 
		} 
	}
}
