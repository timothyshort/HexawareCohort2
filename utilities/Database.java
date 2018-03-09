package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Dependencies: sqljdbc4 JAR
public class Database {
	
	// This function connects to a database and returns data as a double array
	public static String[][] get(String query, int numCols) {
		String[][] dataTable = null;
		int numRows;
		System.out.println("Connecting to database...");
		
		// Write connection String
		String connectionString = GlobalConfig.DB_SERVER +
				";databasename=" + GlobalConfig.DB_DATABASE +
				";username=" + GlobalConfig.DB_USERNAME +
				";password=" + GlobalConfig.DB_PASSWORD;
		
		try {
			// Connect to database
			Connection oConn = DriverManager.getConnection(connectionString);
			System.out.println("--Connection success--");
			
			// Write the query
			Statement oStatement = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet oResult = oStatement.executeQuery(query);
			
			// Defining the size of the data structure
			oResult.last();
			numRows = oResult.getRow();
			dataTable = new String[numRows][numCols];
			
			// Iterate through result set and pass into data structure
			oResult.beforeFirst();
			int row=0;
			while (oResult.next()) {
				for (int i = 0; i < numCols; i++) {
					dataTable[row][i] = oResult.getString(i+1);
				}
				row++;
			}
			
			// Close the connection
			oConn.close();
			System.out.println("Closing database connection");
			
		} catch (SQLException e) {
			System.out.println("ERROR: Connecting to database or executing query\n" + connectionString);
			e.printStackTrace();
		}		
		
		return dataTable;
	}
	
	/*
	// Loading the driver (legacy)
	String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	try {
		Class.forName(dbDriver);
	} catch (ClassNotFoundException e) {
		System.out.println("ERROR: Cannot find driver\n" + dbDriver);
		e1.printStackTrace();
	}
	*/

}
