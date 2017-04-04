package driver;

import java.util.Random;

public class SwimGame extends Game {

	public SwimGame(String gameStr, Official[] officials, Athlete[] athletes) {
		super(gameStr, officials);
		// TODO Auto-generated constructor stub
		int i, offIndex, cnt;
		Athlete[] competitorsTemp = new Athlete[8];
		int exists = 0;
		cnt = 0;
		do{
			offIndex = (int)(new Random().nextDouble() * (athletes.length));
			exists = 0;
			if(athletes[offIndex] instanceof CanSwim){
				System.out.println(offIndex);
				for(i = 0; i < competitorsTemp.length; i++){
					if(competitorsTemp[i]== athletes[offIndex]){
						exists = 1;
					}
				}
				if(exists == 0){
					competitorsTemp[cnt] = athletes[offIndex];
					cnt++;
				}
			}	
		}while( cnt < 8);
		
		setCompetitors(competitorsTemp);
	}

	@Override
	public void runGame() {
		int i, j;
		for(i = 0; i < getCompetitors().length; i++){
			getCompetitors()[i].compete(1);
		}
		Athlete[] orderedComp = new Athlete[8];
		Athlete temp = null;
		orderedComp =  getCompetitors();
		for(i = 0; i < getCompetitors().length; i++){
			for(j = 0; j < getCompetitors().length; j++){
				if(orderedComp[i].getCurrent_score() >  orderedComp[j].getCurrent_score()){
					temp = orderedComp[j];
					orderedComp[j] = orderedComp[i];
					orderedComp[i] = temp;
				}
			}
			orderedComp[i] = temp;
		}
		orderedComp[0].setPoints(orderedComp[0].getPoints() + 5);
		orderedComp[1].setPoints(orderedComp[1].getPoints() + 2);
		orderedComp[2].setPoints(orderedComp[2].getPoints() + 1);
		Menu.showPedestals(orderedComp[0], orderedComp[1], orderedComp[2], this.getOfficial());
	}

}
