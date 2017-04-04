package driver;

import java.util.Random;

public abstract class Game {
	private String ID;
	private String name;
	private Official official;
	private Athlete[] competitors;
	
	public abstract void runGame();
	
	public Game(String gameStr, Official[] officials){
		char[] arrGame = gameStr.toCharArray();
		char[] temp = new char[256];
		int index = 0;
		int subindex = 0;
		int offIndex;
		while(arrGame[index] != '|'){
			temp[subindex] = arrGame[index];
			index++;
			subindex++;
		}
		this.ID = new String(temp);
		index++;
		subindex = 0;
		temp = new char[256];
		while(index < arrGame.length){
			temp[subindex] = arrGame[index];
			index++;
			subindex++;
		}
		this.name = new String(temp);
		
		do{
			offIndex = (int)(new Random().nextDouble() * officials.length);
		}while(officials[offIndex].getTaken() == 1);
		this.official = officials[offIndex];
		this.official.setTaken(1);
	}
	
	public void showParticipants(){
		int i;
		for(i = 0; i < competitors.length; i++){
			System.out.println((i+1) + " - " + competitors[i].getName());
		}
		System.out.println(i + 1 + " - Return");
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Official getOfficial() {
		return official;
	}

	public void setOfficial(Official official) {
		this.official = official;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Athlete[] getCompetitors() {
		return competitors;
	}

	public void setCompetitors(Athlete[] competitors) {
		this.competitors = competitors;
	}
}
