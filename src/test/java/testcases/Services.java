package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import TestNG.TestNG.Base;

public class Services extends Base {
@Test
public void CreateService() throws InterruptedException {
	Actions action=new Actions(driver);
	action.scrollByAmount(0, 2000).perform();

Thread.sleep(5000);
driver.findElement(By.cssSelector("button.capitalize")).click();
Thread.sleep(5000);
driver.findElement(By.cssSelector("input[placeholder=\"What service are you offering?\"]")).sendKeys("Spa And Heair");
Thread.sleep(5000);
driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
}
}
