package driver;

public class Official extends Participant{
	private int taken = 0;
	public Official(String stringedPpt) {
		super(stringedPpt);
	}
	
	public void declareWinner(String name){
		System.out.println("And the winner is...");
		System.out.println(name + "!");
		
	}

	public int getTaken() {
		return taken;
	}

	public void setTaken(int taken) {
		this.taken = taken;
	}
	
}
