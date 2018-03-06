package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {
	// ex filename = "C:\HexawareTraining\Cohort2\Selenium-BDD\TestData\LoginData.txt"
	// This function reads data and returns as a
	public static List<String[]> get(String filename) {
		List<String[]> dataSet = new ArrayList<String[]>();
		
		try {
			// 1. Open the file (in Java)
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			// 2. Read the file (loop while we're not at the end of the file)
			String line;
			while ((line = br.readLine()) != null) {
				// Parse line into array by comma
				String[] record = line.split(",");
				
				// 3. Place data into data structure
				dataSet.add(record);
			}
			
			// 4. Close the file
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File Not Found!\n" + filename);
		} catch (IOException e) {
			System.out.println("ERROR: Could Not Read File!\n" + filename);
		}	
		
		System.out.println("FILE READING FINISHED. " + dataSet.size() + " RECORDS");
		return dataSet;
	}

}
