package pom.Test;

import java.time.Duration;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestNG.TestNG.Base;
import pom.Base.NewBase;
import pom.pages.LogInPage;

public class LogInTest extends NewBase {
 LogInPage loginpage;
	
	
 @BeforeMethod
 public void initPages() {
     loginpage = new LogInPage(driver);
 }
//	   @BeforeClass
//	    public void setUp() throws InterruptedException {
//	        driver = new ChromeDriver();
//	        driver.manage().window().maximize();
//	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	        driver.get("https://staging.that-time.co.uk.picl.co.uk/enter-phone");
//	     
//
//	        loginpage = new LogInPage(driver); // ✅ REQUIRED
//	    }
	
	
	@Test(priority=1)
	public void logIn() throws InterruptedException {
	
	loginpage.enterNumber("7878787878");
	loginpage.click();
	Thread.sleep(4000);
	loginpage.enterPassword("THATtime321!A");
	loginpage.logIn();
	
		
	}

}
