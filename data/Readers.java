package data;

import java.util.List;

import utilities.CSV;
import utilities.Database;
import utilities.Excel;
import utilities.GlobalConfig;

public class Readers {
	// Download source files
	// http://sdettraining.com/projects/freddiemac/testdata/
	public static void main(String[] args) {
		readDB();
	}
	
	private static void readDB() {
		String query = "SELECT * FROM MortgageLoanTestData";
		int fields = 5;
		String[][] dbData = Database.get(query, fields);
		for (String[] record : dbData) {			
			System.out.print("[ ");
			for (String field : record) {
				System.out.print(field + "  ");
			}
			System.out.println("]");
		}
	}
	
	private static void readExcel() {
		// String[][] xlData = Excel.getXLS(GlobalConfig.TESTDATA_DIR + "NewAccountData_XLS.xls");
		String[][] xlData = Excel.get(GlobalConfig.TESTDATA_DIR + "NewAccountData.xlsx");
		for (String[] record : xlData) {			
			System.out.print("[ ");
			for (String field : record) {
				System.out.print(field + "  ");
			}
			System.out.println("]");
		}
	}
	
	private static void readCSV() {
		List<String[]> csvData = CSV.get("C:\\HexawareTraining\\Cohort2\\Selenium-BDD\\TestData\\LoginData.txt");
		for (String[] record : csvData) {
			System.out.println("USERNAME: " + record[0]);
			System.out.println("PASSWORD: " + record[1] + "\n");
		}
	}

}
