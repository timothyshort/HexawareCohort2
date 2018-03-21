package pages.shoppingcart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	WebDriver driver;
	
	public Cart(WebDriver driver) {
		this.driver = driver;
	}
	
	public void pricingDetails(List<List<String>> details) {
		List<WebElement> trTags = driver.findElements(By.tagName("tr"));
		int trTag = trTags.size() - 9 + 2;
		for (List<String> cartDetail : details) {
			String detailPrice = driver.findElement(By.xpath("/html/body/font/form/table/tbody/tr[" + trTag + "]/td[2]/font")).getText();
			System.out.println(cartDetail.get(0) + " " + detailPrice);
			trTag++;
		}
	}

}
