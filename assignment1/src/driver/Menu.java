package driver;

import java.util.Scanner;

public class Menu {
	static public int optionSelect(){
		Scanner s = new Scanner(System.in);
		int option;
		System.out.print("Select option:");
		if(s.hasNextInt()){
			option = s.nextInt();
			return option;
		}else{
			return 0;
		}//if(s.hasNextInt())	
	}
	
	static public void displayError(){
		System.out.println("Error, that option is not available.");
		System.out.println("[press ENTER to continue]");
		Scanner s = new Scanner(System.in);
		if(s.hasNextLine()){
			s.nextLine();
			return;
		}		
	}
}
