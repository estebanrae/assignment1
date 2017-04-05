package driver;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class Game {
	private String ID;
	private String name;
	private Official official;
	private Athlete[] competitors;
	private int hasRun = 0;
	
	public void runGame(){
		if(this.getHasRun() != 0){
			System.out.println("This game has already ran.");
			System.out.println("Are you sure you wish to run it again?[Y/N]");
			Scanner s = new Scanner(System.in);
			String option;
			option = s.nextLine();
			if(!option.equals("Y") && !option.equals("y")){
				return;
			}else{
				getCompetitors()[0].setPoints(getCompetitors()[0].getPoints() - 5);
				getCompetitors()[1].setPoints(getCompetitors()[1].getPoints() - 2);
				getCompetitors()[2].setPoints(getCompetitors()[2].getPoints() - 1);
			}
		}
		int i;
		for(i = 0; i < getCompetitors().length; i++){
			getCompetitors()[i].compete(this);
		}
		Athlete[] orderedComp = new Athlete[8];
		orderedComp =  getCompetitors();
		Arrays.sort(orderedComp);
		orderedComp[0].setPoints(orderedComp[0].getPoints() + 5);
		orderedComp[1].setPoints(orderedComp[1].getPoints() + 2);
		orderedComp[2].setPoints(orderedComp[2].getPoints() + 1);
		this.setCompetitors(orderedComp);
		this.setHasRun(1);
		Menu.showPedestals(orderedComp[0], orderedComp[1], orderedComp[2], this.getOfficial());
	}
	
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

	public int getHasRun() {
		return hasRun;
	}

	public void setHasRun(int hasRun) {
		this.hasRun = hasRun;
	}
}
