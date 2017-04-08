/**
 * Class Game: Defines the parameters and methods that will exist for all games.
 * 
 * @version		1.0 28 MAR 2017
 * @author		Esteban Ramírez
 */
package driver;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class Game {
	private String ID;
	private String name;
	private Official official;
	private Athlete[] competitors;
	private int hasRun = 0;
	
	
	/**
	 * Initializes a new Game object, sets the variables according to a string read from 
	 * a file, and sets the game's official from the array of all officials.
	 * @param gameStr
	 * 		the game's details in string format
	 * @param officials 
	 * 		array containing all officials
	 */
	public Game(String gameStr, Official[] officials){
		char[] arrGame = gameStr.toCharArray();
		char[] temp = new char[256];
		int index = 0;
		int subindex = 0;
		int offIndex;
		while(arrGame[index] != '|'){
			temp[subindex] = arrGame[index];
			index++;
			subindex++;
		}
		this.ID = new String(temp);
		index++;
		subindex = 0;
		temp = new char[256];
		while(index < arrGame.length){
			temp[subindex] = arrGame[index];
			index++;
			subindex++;
		}
		this.name = new String(temp);
		
		do{
			offIndex = (int)(new Random().nextDouble() * officials.length);
		}while(officials[offIndex].getTaken() == 1);
		this.official = officials[offIndex];
		this.official.setTaken(1);
	}
	/**
	 * Checks if the current game has ran already, if so asks the user if they wish to re-run the
	 * game. If the game is decided to run, this method calls the compete() method in all Athlete
	 * objects that exist in the competitors array. Afterwards using the static method sort, the
	 * Athlete objects in the array will be sorted by their score, and points will awarded to the
	 * top 3 athletes. Finally, defines the current game as ran and displays the winners to the user.
	 */
	public void runGame(){
		if(this.getHasRun() != 0){
			System.out.println("This game has already ran.");
			System.out.println("Are you sure you wish to run it again?[Y/N]");
			Scanner s = new Scanner(System.in);
			String option;
			option = s.nextLine();
			if(!option.equals("Y") && !option.equals("y")){
				return;
			}else{
				getCompetitors()[0].setPoints(getCompetitors()[0].getPoints() - 5);
				getCompetitors()[1].setPoints(getCompetitors()[1].getPoints() - 2);
				getCompetitors()[2].setPoints(getCompetitors()[2].getPoints() - 1);
			}
		}
		int i;
		for(i = 0; i < getCompetitors().length; i++){
			competitors[i].compete(this);
		}
		Athlete[] orderedComp = new Athlete[8];
		orderedComp =  getCompetitors();
		Arrays.sort(orderedComp);
		orderedComp[0].setPoints(orderedComp[0].getPoints() + 5);
		orderedComp[1].setPoints(orderedComp[1].getPoints() + 2);
		orderedComp[2].setPoints(orderedComp[2].getPoints() + 1);
		this.setCompetitors(orderedComp);
		this.setHasRun(1);
		Menu.showPedestals(orderedComp[0], orderedComp[1], orderedComp[2], this.getOfficial());
	}
	/**
	 * Accessor for ID variable
	 * @return The current Game ID
	 */
	public String getID() {
		return ID;
	}
	/** 
	 * Accessor for official variable
	 * @return The current Game's official
	 */
	public Official getOfficial() {
		return official;
	}

	/**
	 * Mutator for official variable
	 * @param official
	 */
	public void setOfficial(Official official) {
		this.official = official;
	}
	/** 
	 * Accessor for name variable
	 * @return The current Game's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Accessor for competitors variable
	 * @return The current Game's competitors
	 */
	public Athlete[] getCompetitors() {
		return competitors;
	}
	/**
	 * Mutator for competitors variable
	 * @param competitors
	 */
	public void setCompetitors(Athlete[] competitors) {
		this.competitors = competitors;
	}
	/**
	 * Accessor for hasRun variable
	 * @return a value indicating if the game has run 
	 */
	public int getHasRun() {
		return hasRun;
	}
	/**
	 * Mutator for hasRun variable
	 * @param hasRun
	 */
	public void setHasRun(int hasRun) {
		this.hasRun = hasRun;
	}
}
