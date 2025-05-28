package pom.Test;

import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestNG.TestNG.Base;
import pom.pages.LogInPage;

public class LogInTest {
 LogInPage loginpage;
	WebDriver driver;
	
	
	   @BeforeClass
	    public void setUp() throws InterruptedException {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://stg-vendor.that-time.co.uk/enter-phone");
	     

	        loginpage = new LogInPage(driver); // ✅ REQUIRED
	    }
	
	
	@Test(priority=1)
	public void logIn() throws InterruptedException {
	
	loginpage.enterNumber("7878787878");
	loginpage.click();
	loginpage.enterPassword("THATtime321!A");
	loginpage.logIn();
	
		
	}

}
