/**
 * Class RunningGame: Subclass of Game class, makes sure only Sprinter objects are added as competitors
 * 
 * @version		1.0 28 MAR 2017
 * @author		Esteban Ramírez
 */
package driver;

import java.util.Random;

public class RunningGame extends Game {

	/**
	 * Constructor, assigns an official and a total of 8 participants (randomly) to the current 
	 * Running Game. Also calls the Game class constructor to initialize all other variables.
	 * 
	 *   @param gameStr
	 *   		The game's details as a string read from a file
	 *   @param officials
	 *   		array of all current officials, from which one will be chosen
	 *   @param athletes
	 *   		array of all current athletes, from which 8 will be chosen that implement the
	 *   		CanRun interface
	 */
	public RunningGame(String gameStr, Official[] officials, Athlete[] athletes) {
		super(gameStr, officials);
		// TODO Auto-generated constructor stub
		int i, offIndex, cnt;
		Athlete[] competitorsTemp = new Athlete[8];
		int exists = 0;
		cnt = 0;
		do{
			offIndex = (int)(new Random().nextDouble() * (athletes.length));
			exists = 0;
			if(athletes[offIndex] instanceof CanRun){
				for(i = 0; i < competitorsTemp.length; i++){
					if(competitorsTemp[i]== athletes[offIndex]){
						exists = 1;
					}
				}
				if(exists == 0){
					competitorsTemp[cnt] = athletes[offIndex];
					cnt++;
				}
			}	
		}while( cnt < 8);
		
		setCompetitors(competitorsTemp);
	}

}
