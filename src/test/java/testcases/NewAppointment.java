package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestNG.TestNG.Base;

public class NewAppointment extends Base {
	
	@Test
	public void NewAppointment() throws InterruptedException {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	Thread.sleep(5000);
	//click on the new appointment 
	driver.findElement(By.xpath("//a[ normalize-space()='New Appointment']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='control flex gap-4']//span[@class='slider round']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()=\"Choose a client\"]")).click();	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	String clientName = "Evie";
	WebElement sample = driver.findElement(By.xpath("//input[@placeholder='Search by name, email or number']"));
	sample.sendKeys(clientName);
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//button[@class='btn item ion-color-dark w-full px-4 py-2 border-bottom flex items-center gap-4 relative'])[1]")).click();
	
	
	
	

	
	
	
	/*
//	Select services
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[ normalize-space()='Select a service']")).click();
	
	
	driver.findElement(By.xpath("//div[normalize-space()= 'Men’s Skincare 👨🏻']")).click();
	driver.findElement(By.xpath("//h6[normalize-space()= 'Acne & Oil Control Therapy']")).click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("(//button[normalize-space()='Done'])[1]")).click();

//	driver.findElement(By.xpath("//button[class='btn solid ion-color-secondary w-full']"));
//	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	String expectedMsg = "Appointment created successfully!\n"
			+ "OK";
	Thread.sleep(3000);
	String actualMsg = driver.findElement(By.xpath("//ion-toast[@class=\"ion-color ion-color-success md hydrated\"]")).getText();
	System.out.println(actualMsg.trim());
	Assert.assertEquals(expectedMsg, actualMsg, "actual msg is not matching with expected msg");
	System.out.println("actual = expected");
	*/
	
	}

}