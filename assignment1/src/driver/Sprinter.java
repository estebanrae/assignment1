/**
 * Class Sprinter: Subclass of Athlete class.
 * 
 * @version		1.0 28 MAR 2017
 * @author		Esteban Ramírez
 */
package driver;

import java.util.Random;

public class Sprinter extends Athlete implements CanRun{
	/**
	 * Constructor.
	 * @param stringedPpt
	 * 		the participant's details in string format
	 */
	public Sprinter(String stringedPpt) {
		super(stringedPpt);
	}
	/**
	 * (non-Javadoc)
	 * @see driver.Athlete#compete(driver.Game)
	 * calls run method
	 */
	public void compete(Game x) {
		run();
	}
	/**
	 * (non-Javadoc)
	 * @see driver.CanRun#run()
	 */
	@Override
	public void run() {
		double result = (new Random().nextDouble() * (MAX_RUN - MIN_RUN)) + MIN_RUN;
		setCurrent_score(result);
	}
	
}