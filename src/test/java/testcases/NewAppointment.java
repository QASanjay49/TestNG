package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestNG.TestNG.Base;

public class NewAppointment extends Base {
	
	@Test
	public void NewAppointment() throws InterruptedException {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	Thread.sleep(5000);
	//click on the new appointment 
	driver.findElement(By.xpath("//a[ normalize-space()='New Appointment']")).click();
	
//	driver.findElement(By.cssSelector(".btn[href=\"/dashboard/appointments/appointment/add?datetime=2025-03-04T20:45\"]"));
//	Search client
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[normalize-space()='Choose a client']")).click();
	Thread.sleep(10000);
//	WebElement src= driver.findElement(By.cssSelector("input.ng-pristine.ng-valid.ng-touched"));
	WebElement src= driver.findElement(By.cssSelector("div.pt-1.px-4.pb-4"));
	src.click();
	System.out.println("clicked sucessfully");
	Thread.sleep(4000);
	src.sendKeys("Evie");
	Thread.sleep(10000);
	WebElement resultE = driver.findElement(By.cssSelector("ul.list-none.m-0.p-0"));
	
	Actions ac= new Actions(driver);
	ac.moveToElement(resultE);
	ac.click(resultE);
	Action action= ac.build();
	ac.perform();
	Thread.sleep(2000);
    System.out.println("Successfully clicked the dropdown!");
	
	
	
	
	
	
	
//	Select services
	driver.findElement(By.xpath("//button[ normalize-space()='Select a service']")).click();
	
//	Submit button
	driver.findElement(By.xpath("//button[ normalize-space()='Submit']"));
	
	
	}

}
