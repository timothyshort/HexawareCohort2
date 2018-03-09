package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.Database;
import utilities.GlobalConfig;

public class MortgageLoanDB {
	
	@Test(dataProvider = "dbData")
	public void mortgageLoanTest(String lenderLoanNumber, String sellerNumber,
			String financialInstitution, String amortizationType, String dateOfMortgageNote) {
		
		System.out.println("****NEW TEST*****");
		System.out.println("Lender Loan Number: " + lenderLoanNumber);
		System.out.println("Seller Numebr: " + sellerNumber);
		System.out.println("Financial Institution: " + financialInstitution);
		System.out.println("Amortization Type: " + amortizationType);
		System.out.println("Date of Mortgage: " + dateOfMortgageNote);
	}
	
	@DataProvider
	public String[][] dbData() {
		String query = "SELECT * FROM MortgageLoanTestData";
		int fields = 5;
		return Database.get(query, fields);
	}

}
