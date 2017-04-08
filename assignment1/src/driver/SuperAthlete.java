/**
 * Class Swimmer: Subclass of Athlete class.
 * 
 * @version		1.0 28 MAR 2017
 * @author		Esteban Ramírez
 */

package driver;

import java.util.Random;

public class SuperAthlete extends Athlete implements CanSwim, CanRun, CanCycle{
	/**
	 * Constructor.
	 * @param stringedPpt
	 * 		the participant's details in string format
	 */
	public SuperAthlete(String stringedPpt) {
		super(stringedPpt);
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
	/**
	 * (non-Javadoc)
	 * @see driver.Athlete#compete(driver.Game)
	 * calls a specific method depending on which type of game the SuperAthlete object is
	 * participating in.
	 */
	@Override
	public void compete(Game x) {
		if(x instanceof SwimGame){
			swim();
		}else if(x instanceof RunningGame){
			run();
		}else if(x instanceof CycleGame){
			cycle();
		}
		
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
