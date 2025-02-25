package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestNG.TestNG.Base;

public class MyProfile extends Base {
	
	public By getInputFields(String inputFieldName) {
		return By.xpath(String.format("//ion-label[text()='%s']", inputFieldName));
	}
	
	
	@Test(priority = 3)
	public void Myprofile() throws InterruptedException {
		 Thread.sleep(10000);
		 driver.findElement(getInputFields("Name")).click();
//		 driver.findElement(getInputFields("Name"))
		 Thread.sleep(5000);
	        WebElement NameF = driver.findElement(getInputFields("Name"));
	        NameF.sendKeys("Sanjay");
	        
	        driver.findElement(getInputFields("Bio")).sendKeys("Passionate about skincare and beauty Ellis is the proud owner of glow & co. , a trusted destination for premium face and skin care productsPassionate about skincare and beauty Ellis is the proud owner of glow & co. , a trusted destination for premium face and skin care products");
	        
	}
}

