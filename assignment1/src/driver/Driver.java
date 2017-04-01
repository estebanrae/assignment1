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
			MainMenu.showMenu();
			menuOpt = Menu.optionSelect();
			if(menuOpt == 1){
				GamesMenu.showMenu();
				subMenuOpt = Menu.optionSelect();
			}else if(menuOpt ==2){
				System.out.println("Option 2");
			}else if(menuOpt ==3){
				System.out.println("Option 3");
			}else if(menuOpt ==4){
				System.out.println("Option 4");
			}else if(menuOpt ==5){
				System.out.println("Option 5");
			}else if(menuOpt != 6){
				Menu.displayError();
			}
		}while(menuOpt != 6);
		
	}
	
	public void init(){
		int i, swimmerLength, cycleLength, sprinterLength, swimGameLength, cycleGameLength, sprintGameLength;
		/* Initializing all athletes */
		String[] swimmersTxt= Reader.readFile("../files/swimmers.txt");
		swimmerLength = Reader.lines;
		String[] cyclistsTxt= Reader.readFile("../files/cyclists.txt");
		cycleLength = Reader.lines;
		String[] sprintersTxt= Reader.readFile("../files/sprinters.txt");
		sprinterLength = Reader.lines;
		athletes = new Athlete[swimmerLength + cycleLength + sprinterLength];
		for (i = 0; i < swimmerLength; i++){
			athletes[i] = new Swimmer(swimmersTxt[i]);
		}
		for (i = swimmerLength; i < cycleLength; i++){
			athletes[i] = new Cyclist(cyclistsTxt[i]);
		}
		for (i = cycleLength; i < sprinterLength; i++){
			athletes[i] = new Sprinter(sprintersTxt[i]);
		}
		/* Initializing officials */
		String[] officialTxt= Reader.readFile("../files/officials.txt");
		int officialLength = Reader.lines;
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
			games[i] = new SwimGame(swimGamesTxt[i]);
		}
		for(i = swimGamesLength; i< cycleGamesLength; i++){
			games[i] = new CycleGame(cycleGamesTxt[i]);
		}
		for(i = cycleGamesLength; i< sprinterGamesLength; i++){
			games[i] = new RunningGame(sprinterGamesTxt[i]);
		}	
	}
}
