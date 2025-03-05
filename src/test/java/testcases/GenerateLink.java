package testcases;

import org.openqa.selenium.By;

import TestNG.TestNG.Base;

public class GenerateLink extends Base {
	
	public void Generatelink() {
		driver.findElement(By.xpath("//a[ normalize-space()='Generate Link']")).click();
	}

}
