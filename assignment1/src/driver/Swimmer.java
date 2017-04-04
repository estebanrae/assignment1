package driver;

import java.util.Random;

public class Swimmer extends Athlete implements CanSwim{

	public Swimmer(String stringedPpt) {
		super(stringedPpt);
	}

	public void compete(int x) {
		swim();
	}

	@Override
	public void swim() {
		double result = (new Random().nextDouble() * (MAX_SWIM - MIN_SWIM)) + MIN_SWIM;
		setCurrent_score(result);
	}
}
