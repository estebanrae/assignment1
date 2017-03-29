package driver;

public class Swimmer extends Athlete{

	public Swimmer(String stringedPpt) {
		super(stringedPpt);
	}

	public double compete() {
		System.out.println("swimming!");
		setPoints(2);
		return 0;
	}

}
