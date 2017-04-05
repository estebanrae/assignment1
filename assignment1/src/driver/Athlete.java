package driver;

public abstract class Athlete extends Participant implements Comparable<Athlete>{
	private double current_score = 0;
	private int points;
	public Athlete(String stringedPpt) {
		super(stringedPpt);
		// TODO Auto-generated constructor stub
	}
	public abstract void compete(Game x);
	
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
	public int compareTo(Athlete other){
		if(this.current_score < other.current_score){
			return -1;
		}else if(this.current_score > other.current_score){
			return 1;
		}else{
			return 0;
		}
	}
}
