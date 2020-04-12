package mercuryTours.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;

import mercuryTours.pageObject.Home;
import mercuryTours.pageObject.Registration;

import org.testng.annotations.AfterClass;

public class RegistrationTest {
	
	WebDriver driver; 
	Registration regist; 
	WebDriverWait wait; 
	
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
	}

	@Test
	public void testRegLink() {
		// postavlja url u browser
		driver.get(Home.HOME_URL);
		
		// clik na Registration link
		Home.clickOnRegLink(driver);
		
		regist.waitUsernameElement(driver);
		
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://newtours.demoaut.com/mercuryregister.php"; 
		
		Assert.assertTrue(currentUrl.contains(expectedUrl));
		
	}
	
	@Test
	public void testRegForm() {
		
		driver.navigate().to(Registration.REG_URL);
		regist = new Registration(); 
		
		regist.inputUsername(driver, "pera");
		regist.inputPassword(driver, "Pera123");
		regist.inputConfPassword(driver, "Pera123");
		regist.clickSubmit(driver);
		
		String expectedUrl = "http://newtours.demoaut.com/create_account_success.php"; 
		String acctualUrl = driver.getCurrentUrl(); 
		
		Assert.assertTrue(acctualUrl.contains(expectedUrl));
		
		
		
		
		
	}

	@AfterClass
	public void closeBrowser() {		
		driver.quit();
	}

}
