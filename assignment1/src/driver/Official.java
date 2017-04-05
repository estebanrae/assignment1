package driver;

public class Official extends Participant{
	private int taken = 0;
	public Official(String stringedPpt) {
		super(stringedPpt);
	}

	public int getTaken() {
		return taken;
	}

	public void setTaken(int taken) {
		this.taken = taken;
	}
	
}
