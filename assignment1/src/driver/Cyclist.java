/**
 * Class Cyclist: Subclass of Athlete class.
 * 
 * @version		1.0 28 MAR 2017
 * @author		Esteban Ramírez
 */
package driver;

import java.util.Random;

public class Cyclist extends Athlete implements CanCycle{
	private final int MAX_CYCLE = 500;
	private final int MIN_CYCLE = 800;
	
	/**
	 * Constructor.
	 * @param stringedPpt
	 * 		the participant's details in string format
	 */
	public Cyclist(String stringedPpt) {
		super(stringedPpt);
	}
	/**
	 * (non-Javadoc)
	 * @see driver.Athlete#compete(driver.Game)
	 * calls cycle method
	 */
	public void compete(Game x) {
		cycle();
	}
	/**
	 * (non-Javadoc)
	 * @see driver.CanCycle#cycle()
	 */
	@Override
	public void cycle() {
		double result = (new Random().nextDouble() * (MAX_CYCLE - MIN_CYCLE)) + MIN_CYCLE;
		setCurrent_score(result);
	}
}