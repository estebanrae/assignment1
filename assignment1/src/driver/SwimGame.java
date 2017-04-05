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
}
