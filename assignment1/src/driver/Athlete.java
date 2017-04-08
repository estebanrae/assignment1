/**
 * Class Athlete: Abstract class for all athlete objects that will compete in the game
 * 
 * @version		1.0 28 MAR 2017
 * @author		Esteban Ramírez
 */
package driver;

public abstract class Athlete extends Participant implements Comparable<Athlete>{
	private double current_score = 0;
	private int points = 0;
	/**
	 * Constructor
	 * @param stringedPpt
	 * 		receives the participant's details in string format
	 */
	public Athlete(String stringedPpt) {
		super(stringedPpt);
	}
	/**
	 * Allows an athlete to compete on a game, after defining the type of game
	 * @param x
	 * 		the game that the Athlete will compete in
	 */
	public abstract void compete(Game x);
	
	/**
	 *  Accessor for points variable
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * Mutator for points variable
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * Accessor for current_score variable
	 */
	public double getCurrent_score() {
		return current_score;
	}
	/**
	 * Mutator for points variable
	 */
	public void setCurrent_score(double current_score) {
		this.current_score = current_score;
	}
	/**
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * Uses variable current_score to compare between athletes 
	 */
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
