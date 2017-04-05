package driver;

import java.util.Random;

public class Cyclist extends Athlete implements CanCycle{
	private final int MAX_CYCLE = 500;
	private final int MIN_CYCLE = 800;
	
	public Cyclist(String stringedPpt) {
		super(stringedPpt);
	}

	public void compete(Game x) {
	}

	@Override
	public void cycle() {
		double result = (new Random().nextDouble() * (MAX_CYCLE - MIN_CYCLE)) + MIN_CYCLE;
		setCurrent_score(result);
	}
}