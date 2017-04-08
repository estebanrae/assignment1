/**
 * Participant Class: The general class that defines variables all athletes and officials
 * will share. The way to decode the string read from a file into parameters is also 
 * described here.
 * 
 * @version		1.0 28 MAR 2017
 * @author		Esteban Ramírez
 */
package driver;

public abstract class Participant {
	private String ID;
	private String name;
	private int age;
	private String state;
	
	/**
	 * Constructor. Decodes the string read from a file into a single participant object, defining
	 * the name, id, age and state. These are all parameters that are shared within officials and athletes.
	 * 
	 * @param stringedPpt
	 * 		the string to be decoded.
	 */
	public Participant(String stringedPpt){
		char[] arrPpt = stringedPpt.toCharArray();
		char[] temp = new char[256];
		int index = 0;
		int subindex = 0;
		while(arrPpt[index] != '|'){
			temp[subindex] = arrPpt[index];
			index++;
			subindex++;
		}
		this.ID = new 	String(temp);
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
		index++;
		subindex = 0;
		temp = new char[100];
		while(index < arrPpt.length){
			temp[subindex] = arrPpt[index];
			index++;
			subindex++;
		}
		this.state = new String(temp);
	}

	/**
	 * Accessor for name variable.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	public String getID() {
		return ID;
	}
}
