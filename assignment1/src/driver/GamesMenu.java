package driver;

public class GamesMenu {

	static public void showMenu(Game[] games) {
		int i;
		System.out.println("Select a game");
		System.out.println("********************************");
		for(i = 0; i < games.length; i++){
			System.out.println((i+1) + " - " + games[i].getID() + ", " + games[i].getName());
		}
		System.out.println(i + " - Return");
	}
	
	static public void selectGame(Game[] games){
		int subMenuOpt = Menu.optionSelect();
		if(subMenuOpt < 1 || subMenuOpt > games.length){
			Menu.displayError();
		}else if(subMenuOpt == games.length){
			return;
		}else{
			MainMenu.setSelectedGame(games[subMenuOpt - 1]);
		}
	}
	
}
