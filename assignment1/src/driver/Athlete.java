package driver;

public abstract class Athlete extends Participant {
	private double current_score;
	public Athlete(String stringedPpt) {
		super(stringedPpt);
		// TODO Auto-generated constructor stub
	}
	private int points;
	public abstract void compete(int x);
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

	public double getCurrent_score() {
		return current_score;
	}

	public void setCurrent_score(double current_score) {
		this.current_score = current_score;
	}
}
