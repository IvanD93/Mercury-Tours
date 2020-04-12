package mercuryTours.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
	
		public static String HOME_URL = "http://newtours.demoaut.com/";
		public static By register = By.linkText("REGISTER");
		
		public static void clickOnRegLink(WebDriver driver) {
			
			WebElement regLink = driver.findElement(register);
			regLink.click();
			
		}
		
}
