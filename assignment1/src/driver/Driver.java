package driver;

public class Driver {
	/*
	private Athlete[] swimmers;
	private Athlete[] cyclists;
	private Athlete[] sprinters;
	*/
	private Athlete[] athletes;
	private Official[] officials;
	private Game[] games;
	
	public void options() {
		int menuOpt, subMenuOpt;
		do{
			Menu.showMainMenu();
			menuOpt = Menu.optionSelect();
			if(menuOpt == 1){
				Menu.showGameMenu(games);
				Menu.selectGame(games);			
			}else if(menuOpt ==2){
				Menu.showPredictionMenu();
			}else if(menuOpt ==3){
				Menu.getSelectedGame().runGame();
				System.out.println("Option 3");
			}else if(menuOpt ==4){
				System.out.println("Option 4");
			}else if(menuOpt ==5){
				Menu.showAthletePoints(athletes);
				System.out.println("Option 5");
			}else if(menuOpt != 6){
				Menu.displayError();
			}
		}while(menuOpt != 6);
		
	}
	
	public void init(){
		int i, swimmerLength, cycleLength, sprinterLength, swimGameLength, cycleGameLength, sprintGameLength, superAthleteLength;
		/* Initializing all athletes */
		String[] swimmersTxt= Reader.readFile("../files/swimmers.txt");
		swimmerLength = Reader.lines;
		String[] cyclistsTxt= Reader.readFile("../files/cyclists.txt");
		cycleLength = Reader.lines;
		String[] sprintersTxt= Reader.readFile("../files/sprinters.txt");
		sprinterLength = Reader.lines;
		String[] superAthleteTxt= Reader.readFile("../files/super_athletes.txt");
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
		/* Initializing officials */
		String[] officialTxt= Reader.readFile("../files/officials.txt");
		int officialLength = Reader.lines;
		officials = new Official[officialLength];
		for(i = 0; i< officialLength; i++){
			officials[i] = new Official(officialTxt[i]);
		}
		/* Initializing all games */
		String[] swimGamesTxt= Reader.readFile("../files/swimgames.txt");
		int swimGamesLength = Reader.lines;
		String[] cycleGamesTxt= Reader.readFile("../files/cyclegames.txt");
		int cycleGamesLength = Reader.lines;
		String[] sprinterGamesTxt= Reader.readFile("../files/sprintergames.txt");
		int sprinterGamesLength = Reader.lines;
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
}
