package driver;

import java.util.Random;

public class SuperAthlete extends Athlete implements CanSwim, CanRun, CanCycle{

	public SuperAthlete(String stringedPpt) {
		super(stringedPpt);
	}

	@Override
	public void swim() {
		double result = (new Random().nextDouble() * (MAX_SWIM - MIN_SWIM)) + MIN_SWIM;
		setCurrent_score(result);		
	}

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

	@Override
	public void cycle() {
		double result = (new Random().nextDouble() * (MAX_CYCLE - MIN_CYCLE)) + MIN_CYCLE;
		System.out.println(result);
	}

	@Override
	public void run() {
		double result = (new Random().nextDouble() * (MAX_RUN - MIN_RUN)) + MIN_RUN;
		System.out.println(result);	
	}
}
