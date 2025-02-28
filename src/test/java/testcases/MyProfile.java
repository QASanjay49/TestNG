package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestNG.TestNG.Base;

public class MyProfile extends Base {
	
//	public By getInputFields(String inputFieldName) {
//		return By.xpath(String.format("//ion-label[text()='%s']", inputFieldName));
//	}
	public By getInputField(String inputField) {
		return By.xpath(String.format("//input[@name='%s']", inputField));
	}
	
	
	
//	@Test(priority = 3)
//	public void Myprofile() throws InterruptedException {
//		 Thread.sleep(10000);
//		 driver.findElement(getInputFields("Name")).click();
//		 Thread.sleep(5000);
//	        WebElement NameF = driver.findElement(getInputFields("Name"));
//	        NameF.sendKeys("Sanjay");
//	        
//	        driver.findElement(getInputFields("Bio")).sendKeys("Passionate about skincare and beauty Ellis is the proud owner of glow & co. , a trusted destination for premium face and skin care productsPassionate about skincare and beauty Ellis is the proud owner of glow & co. , a trusted destination for premium face and skin care products");
//	        
//	}
	@Test(priority = 3)
	public void Name() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(getInputField("name")).click();
		driver.findElement(getInputField("name")).clear();
		driver.findElement(getInputField("name")).sendKeys("Rajesh");
		driver.findElement(getInputField("name")).sendKeys(Keys.TAB);
//		driver.findElement(By.xpath("//input[@name='name']")).click();
		
	}
	@Test(priority = 4)
	public void Bio() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(getInputField("bio")).click();
		driver.findElement(getInputField("bio")).clear();
		driver.findElement(getInputField("bio")).sendKeys("Rajesh Rajesh Rajesh Rajesh Rajesh Rajesh Rajesh Rajesh Rajesh");
//		driver.findElement(By.xpath("//input[@name='name']")).click();
		
	}
}

