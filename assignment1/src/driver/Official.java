package driver;

public class Official extends Participant{

	public Official(String stringedPpt) {
		super(stringedPpt);
	}
	
	public void declareWinner(String name){
		System.out.println("And the winner is...");
		System.out.println(name + "!");
		
	}
	
}
