package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

	/*
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[normalize-space()='Choose a client']")).click();
	Thread.sleep(10000);
//	WebElement src= driver.findElement(By.cssSelector("input.ng-pristine.ng-valid.ng-touched"));
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.pt-1.px-4.pb-4")));
	element.sendKeys("Evie");
	
	
	WebElement developers_dropdown = driver.findElement(By.id	("developers-menu-toggle"));
	Select objSelect = new Select(developers_dropdown);
	
	
	
//	WebElement src= driver.findElement(By.cssSelector("div.pt-1.px-4.pb-4"));
//	src.click();
//	System.out.println("clicked sucessfully");
//	Thread.sleep(4000);
//	src.sendKeys("Evie");
	
	Thread.sleep(10000);
	WebElement resultE = driver.findElement(By.cssSelector("ul.list-none.m-0.p-0"));
	
	Actions ac= new Actions(driver);
	ac.moveToElement(resultE);
	ac.click(resultE);
	Action action= ac.build();
	ac.perform();
	Thread.sleep(2000);
    System.out.println("Successfully clicked the dropdown!");
    
    */
	
	
	
	
	
	
//	Select services
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[ normalize-space()='Select a service']")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[normalize-space()= 'Men’s Skincare 👨🏻']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//h6[normalize-space()= 'Acne & Oil Control Therapy']")).click();
	Thread.sleep(10000);
	
	driver.findElement(By.xpath("//button[@class='btn solid ion-color-secondary w-full']"));
//	driver.findElement(By.xpath("contains(text(), 'Done')")).click();
//	normalize-space()= 'Done']
//	driver.findElement(By.xpath("//button[class='btn solid ion-color-secondary w-full']"));
	Thread.sleep(2000);
	driver.findElement(By.xpath("button.btn.solid.ion-color-secondary.w-full.max-w-screen-sm"));
	
	
	Thread.sleep(2000);
//	Submit button
	driver.findElement(By.xpath("//button[ normalize-space()='Submit']"));
	
	
	}

}
