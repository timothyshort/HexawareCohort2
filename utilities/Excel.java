package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static String[][] getXLS(String filename) {
		String[][] dataTable = null;
		
		try {
			// Create the Excel reader
			File file = new File(filename);
			FileInputStream xlFile = new FileInputStream(file);
			HSSFWorkbook xlBook = new HSSFWorkbook(xlFile);
			HSSFSheet xlSheet = xlBook.getSheetAt(0);
			
			// Get the number of rows and columns to define data table size
			int rows = xlSheet.getLastRowNum() + 1;
			int cols = xlSheet.getRow(0).getLastCellNum();
			dataTable = new String[rows][cols];
			System.out.println("Dataset: " + rows + " records by " + cols + " fields");
			
			// Iterate through the data
			for (int i = 0; i < rows; i++ ) {
				HSSFRow xlRow = xlSheet.getRow(i);
				for (int j = 0; j < cols; j++) {
					HSSFCell xlCell = xlRow.getCell(j);
					// Add data to data table
					dataTable[i][j] = xlCell.toString();
				}
			}		
			
			// Close resource
			xlFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found!\n" + filename);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR: Could not read file!\n" + filename);
			e.printStackTrace();
		}
		
		System.out.println("Finished reading Excel file");
		return dataTable;
	}
	
	public static String[][] get(String filename) {
		String[][] dataTable = null;
		
		try {
			// Create the Excel reader
			File file = new File(filename);
			FileInputStream xlFile = new FileInputStream(file);
			XSSFWorkbook xlBook = new XSSFWorkbook(xlFile);
			XSSFSheet xlSheet = xlBook.getSheetAt(0);
			
			// Get the number of rows and columns to define data table size
			int rows = xlSheet.getLastRowNum() + 1;
			int cols = xlSheet.getRow(0).getLastCellNum();
			dataTable = new String[rows][cols];
			System.out.println("Dataset: " + rows + " records by " + cols + " fields");
			
			// Iterate through the data
			for (int i = 0; i < rows; i++ ) {
				XSSFRow xlRow = xlSheet.getRow(i);
				for (int j = 0; j < cols; j++) {
					XSSFCell xlCell = xlRow.getCell(j);
					// Add data to data table
					dataTable[i][j] = xlCell.toString();
				}
			}		
			
			// Close resource
			xlFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found!\n" + filename);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR: Could not read file!\n" + filename);
			e.printStackTrace();
		}
		
		System.out.println("Finished reading Excel file");
		return dataTable;
	}
	
	/*
	// As a List<String[]>
	public static List<String[]> get(String filename, String sheet) {
		List<String[]> dataTable = new ArrayList<String[]>();
		
		try {
			// Create the Excel reader
			File file = new File(filename);
			FileInputStream xlFile = new FileInputStream(file);
			XSSFWorkbook xlBook = new XSSFWorkbook(xlFile);
			XSSFSheet xlSheet = xlBook.getSheet(sheet);
			
			// Get the number of rows and columns to define data table size
			int rows = xlSheet.getLastRowNum() + 1;
			int cols = xlSheet.getRow(0).getLastCellNum();
			String[] record = new String[cols];
			System.out.println("Dataset: " + rows + " records by " + cols + " fields");
			
			// Iterate through the data
			for (int i = 0; i < rows; i++ ) {
				XSSFRow xlRow = xlSheet.getRow(i);
				for (int j = 0; j < cols; j++) {
					XSSFCell xlCell = xlRow.getCell(j);
					// Add data to data table
					record[j] = xlCell.toString();
				}
				dataTable.add(record);
			}	
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found!\n" + filename);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR: Could not read file!\n" + filename);
			e.printStackTrace();
		}
		
		System.out.println("Finished reading Excel file");
		return dataTable;
	}
	*/

}
