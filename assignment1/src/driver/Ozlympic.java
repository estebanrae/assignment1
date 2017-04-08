/**
 * Class Ozlympic: This is the main class of our program, it simply initializes our driver class 
 *  and our program.
 *  
 * @version		1.0 27 MAR 2017
 * @author		Esteban Ramírez
 * 
 */
package driver;

public class Ozlympic {
	/**
	 * Main method for the whole program.
	 * @param args
	 */
	public static void main(String[] args) {
		Driver prgrm = new Driver();
		prgrm.initializeAthletes();
		prgrm.initializeOfficials();
		prgrm.initializeGames();
		prgrm.mainMenu();

	}

}
