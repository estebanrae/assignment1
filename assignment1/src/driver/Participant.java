package driver;

public class Participant {
	private String ID;
	private String name;
	private int age;
	private String state;
	
	public Participant(String ID, String name, int age, String state){
		
	}
	
	public Participant(String stringedPpt){
		char[] arrPpt = stringedPpt.toCharArray();
		char[] temp = new char[100];
		int index = 0;
		int subindex = 0;
		while(arrPpt[index] != '|'){
			temp[subindex] = arrPpt[index];
			index++;
			subindex++;
		}
		this.ID = new String(temp);
		index++;
		subindex = 0;
		temp = new char[100];
		while(arrPpt[index] != '|'){
			temp[subindex] = arrPpt[index];
			index++;
			subindex++;
		}
		this.name = new String(temp);
		index++;
		subindex = 0;
		temp = new char[100];
		while(arrPpt[index] != '|'){
			temp[subindex] = arrPpt[index];
			index++;
			subindex++;
		}
		//this.age = Integer.parseInt(temp.toString());
		index++;
		subindex = 0;
		temp = new char[100];
		while(index < arrPpt.length){
			temp[subindex] = arrPpt[index];
			index++;
			subindex++;
		}
		this.state = new String(temp);
		
		System.out.println(this.state);
		//System.out.println(this.ID);
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
