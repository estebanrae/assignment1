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
	public void compete(int x) {
		if(x == 1){
			swim();
		}else if(x == 2){
			run();
		}else if(x == 3){
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
