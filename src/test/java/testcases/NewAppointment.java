package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestNG.TestNG.Base;

public class NewAppointment extends Base {
	
	public void NewAppointment() throws InterruptedException {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	Thread.sleep(1000);
	//click on the new appointment 
	driver.findElement(By.cssSelector(".btn[href=\"/dashboard/appointments/appointment/add?datetime=2025-03-04T20:45\"]"));
//	Search client
	driver.findElement(By.cssSelector("button#client-input-btn-1741103722818")).click();
//	Select services
	driver.findElement(By.xpath("//button[ normalize-space()='Select a service']")).click();
	
	}

}
