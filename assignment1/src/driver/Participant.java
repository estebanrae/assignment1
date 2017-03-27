package driver;

public class Participant {
	private String ID;
	private String name;
	private int age;
	private String state;
	
	public Participant(String ID, String name, int age, String state){
		
	}
	
	public Participant(String stringedPpt){
		
	}
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
