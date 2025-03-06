package testcases;

import org.openqa.selenium.By;

import TestNG.TestNG.Base;


//public By getMenuEle(String menuName) {
//	return By.xpath(String.format("//span[text()='%s']", menuName));
//}


public class Calendar extends Base{
	
	public By getMenuEle(String menuName) { 
	return By.xpath(String.format("//a[ normalize-space()='%s']", menuName));
	}
	
	public By getMenuBtn(String menuNameBtn) {
		return By.xpath(String.format("//button[normalize-space()='%s']", menuNameBtn));
	}
	
	public void NewAppointment() {
	driver.findElement(getMenuEle("New Appointment")).click();
	}
	
	public void GenerateLink() {
		driver.findElement(getMenuEle(" Generate Link ")).click();
	}
	
	public void BlockATime() {
		driver.findElement(getMenuBtn(" Block a Time ")).click();
	}
	
	public void UnblockATime() {
		driver.findElement(getMenuBtn(" Unblock a Time ")).click();	
	}
	
}

