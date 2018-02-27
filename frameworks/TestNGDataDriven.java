package frameworks;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TestNGDataDriven {
  @Test(dataProvider = "testData")
  public void myTestNGTest(String email, String password) {
	  System.out.println("testData Data: " + email + " " + password);
  }
  
  @Test(dataProvider = "dp")
  public void sampleTest(int number, String letter) {
	  System.out.println("dp Data: " + number + " " + letter);
  }

  
  @DataProvider
  private String[][] testData() {
	  String[][] usernames = {
				{ "tim@testemail.com", "timspassword" }, 
				{ "jordan@freddiemail.com", "jordanspassword" },
				{ "kelly@freddiemail.com", "kellyspassword "}
			};
	  return usernames;
  }
  
  @DataProvider
  private Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
