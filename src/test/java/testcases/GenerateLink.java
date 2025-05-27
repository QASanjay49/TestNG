package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestNG.TestNG.Base;

public class GenerateLink extends Base {
	
	@Test(priority=4)
	public void Generatelink() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[ normalize-space()='Generate Link']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()=\"Choose a client\"]")).click();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String clientName = "Evie";
		WebElement sample = driver.findElement(By.xpath("//input[@placeholder='Search by name, email or number']"));
		sample.sendKeys(clientName);
		
		Thread.sleep(5000);
		/*
		driver.findElement(By.xpath("//span[normalize-space()='Choose a client']"));
		Thread.sleep(5000);
		String clientNames= "Evie";
		WebElement samples = driver.findElement(By.xpath("//input[@placeholder=\"Search by name, email or number\"]"));
		samples.sendKeys(clientNames);
		Thread.sleep(5000);
		*/
		driver.findElement(By.xpath("//button[@class='btn item ion-color-dark w-full px-4 py-2 border-bottom flex items-center gap-4 relative']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Select a service']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h4[normalize-space()='Spa']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h6[normalize-space()='Pedicures']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Done']")).click();
		
		
		
		
	}

}
