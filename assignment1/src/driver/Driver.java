package driver;

public class Driver {

	public static void options() {
		//String[] swimmersTxt= Reader.readFile("../files/swimmers.txt");
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
}
