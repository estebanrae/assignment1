package driver;

public abstract class Athlete extends Participant {
	public Athlete(String stringedPpt) {
		super(stringedPpt);
		// TODO Auto-generated constructor stub
	}
	private int points;
	public abstract double compete();
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
}
