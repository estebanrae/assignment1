/**
 * Class Reader: Reads all lines from a file, and stores the lenght of the last read line in a 
 * variable.
 * 
 * @version		1.0 28 MAR 2017
 * @author		Esteban Ramírez
 */
package driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	static int lines;
	/**
	 * Reads a file and returns the result as an array of lines
	 * @param path
	 * 		the relative path of the file to be read
	 * @return the array of lines read from the file
	 */
	static public String[] readFile(String path){
		String[] lines = new String[30];
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			int cnt = 0;
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				lines[cnt] = sCurrentLine;
				cnt++;
			}
			Reader.lines = cnt;

		} catch (IOException e) {
			lines[0] = "Error";
			lines[1] = e.getMessage();
		}
		return lines;
	}
}
