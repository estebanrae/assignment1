package driver;

public class Driver {

	public static void options() {
		int i;
		String[] swimmersTxt= Reader.readFile("../files/swimmers.txt");
		Athlete[] swimmers = new Swimmer[Reader.lines];
		for(i = 0; i< swimmers.length; i++){
			swimmers[i] = new Swimmer(swimmersTxt[i]);
		}
		int menuOpt, subMenuOpt;
		do{
			MainMenu.showMenu();
			menuOpt = Menu.optionSelect();
			if(menuOpt == 1){
				GamesMenu.showMenu();
				subMenuOpt = Menu.optionSelect();
				SwimGame swim1 = new SwimGame("");
				swim1.runGame(swimmers[0]);
				System.out.println(swimmers[0].getPoints());
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
}
