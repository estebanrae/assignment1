package driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	static public String[] readFile(String path){
		String[] lines = new String[30];
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			int cnt = 0;
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				lines[cnt] = sCurrentLine;
				cnt++;
			}
			System.out.println(lines.length);

		} catch (IOException e) {
			lines[0] = "Error";
			lines[1] = e.getMessage();
		}
		return lines;
	}
}
