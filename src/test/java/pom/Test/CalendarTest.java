package pom.Test;

import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestNG.TestNG.Base;
import pom.Base.NewBase;
import pom.pages.CalendarPage;


public class CalendarTest extends NewBase{
	
	CalendarPage calendarpage;
	@BeforeMethod
	public void init() {
		calendarpage = new CalendarPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=3)
	public void newAppointment() throws InterruptedException {	
		Thread.sleep(4000);
		calendarpage.clickNewAppointment();	
		Thread.sleep(4000);
		calendarpage.allOptions();
		
//		calendarpage.trail("Evie");
		
		
//		calendarpage.walkInButton();
//		calendarpage.clientName();
//		calendarpage.clientNameSearch("Evie");
//		Thread.sleep(6000);
//		calendarpage.selectClientFromOptions();
		
		
		
	}
	
	public void genaretLink() {
		calendarpage.clickGenerateLink();
	}
	public void blockATime() {
		calendarpage.clickBlockATime();
	}
	public void unblockATime() {
		calendarpage.clickUnblockATime();
	}
	
	
	}

