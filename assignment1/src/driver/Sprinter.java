package driver;

import java.util.Random;

public class Sprinter extends Athlete implements CanRun{
	public Sprinter(String stringedPpt) {
		super(stringedPpt);
	}

	public void compete(int x) {
		
	}

	@Override
	public void run() {
		double result = (new Random().nextDouble() * (MAX_RUN - MIN_RUN)) + MIN_RUN;
		System.out.println(result);
	}
	
}