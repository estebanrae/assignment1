/**
 * Class Swimmer: Subclass of Athlete class.
 * 
 * @version		1.0 28 MAR 2017
 * @author		Esteban Ramírez
 */
package driver;

import java.util.Random;

public class Swimmer extends Athlete implements CanSwim{
	/**
	 * Constructor.
	 * @param stringedPpt
	 * 		the participant's details in string format
	 */
	public Swimmer(String stringedPpt) {
		super(stringedPpt);
	}
	/**
	 * (non-Javadoc)
	 * @see driver.Athlete#compete(driver.Game)
	 * calls swim method
	 */
	public void compete(Game x) {
		swim();
	}
	/**
	 * (non-Javadoc)
	 * @see driver.CanSwim#swim()
	 */
	@Override
	public void swim() {
		double result = (new Random().nextDouble() * (MAX_SWIM - MIN_SWIM)) + MIN_SWIM;
		setCurrent_score(result);
	}
}
