package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestNG.TestNG.Base;

public class MyProfile extends Base {
		
	
//	public By getInputFields(String inputFieldName) {
//		return By.xpath(String.format("//ion-label[text()='%s']", inputFieldName));
//	}
//	public By getInputField(String inputField) {
//		return By.xpath(String.format("//input[@name='%s']", inputField));
//	}
		
//		public By getInputFields(String inputFields) throws InterruptedException {
//			Thread.sleep(10000);
//			return By.cssSelector("input.native-input.sc-ion-input-md[name='%s']");
//			
//		}
		@Test(priority = 3)
		public By getInputFields(String inputFields) throws InterruptedException {
		    Thread.sleep(10000);
		    return By.cssSelector(String.format("input.native-input.sc-ion-input-md[name='%s']", inputFields));
		}
		@Test(priority = 4)
		
		public void MyBioUpdate() throws InterruptedException {
			Thread.sleep(10000);
			
			WebElement nameF = driver.findElement(getInputFields("name"));
			nameF.clear();
			nameF.clear();
			nameF.sendKeys("Carry kor");
			
			/*
			WebElement bioF = driver.findElement(getInputFields("bio"));
			bioF.click();
			bioF.clear();
			bioF.sendKeys("Passionate about skincare and beauty Ellis is the proud owner of glow & co. , a trusted destinationPassionate about skincare and beauty Ellis is the proud owner of glow & co. , a trusted destination");
		*/
			
			WebElement emailF = driver.findElement(getInputFields("email"));
			emailF.click();
			emailF.clear();
			emailF.sendKeys("carrykor@gmail.com");
			emailF.sendKeys(Keys.TAB);
			
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
//
//            // Wait for visibility and clickability to ensure the button is interactable
//            wait.until(ExpectedConditions.visibilityOf(loginButton));
//            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
//            loginButton.click();
			
            
            
			
//			driver.findElement(By.cssSelector("ion-button.mt-auto[ng-reflect-color=\"secondary\"]")).click();
			
		}
	@Test(priority = 5)
	    public void scrollToBottom() throws InterruptedException {
		Thread.sleep(5000);
			Actions action=new Actions(driver);
//			action.sendKeys(Keys.PAGE_DOWN);
			action.scrollByAmount(0, 1000).perform();
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        Thread.sleep(10000);
	        WebElement webele = driver.findElement(By.cssSelector("ion-button[type=\"submit\"]"));
			webele.click();
	    } 
		
		// Scroll down to the bottom of the page  
     
        
		
		
	/*	@Test(priority = 5)
		
		public void scrollToBottomAndSave() {
		    try {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		        // Scroll to the bottom of the page
		        System.out.println("Scrolling to the bottom of the page...");
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		        // Wait for the outer shadow host (e.g., ion-content) to be present
		        WebElement outerShadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".modal-container.flex.flex-col.bg-white.border-top.sidebar")));
		        Thread.sleep(10000);
		        // Find the save button in the Shadow DOM
		        WebElement save = wait.until(webDriver -> {
		            WebElement element = (WebElement) js.executeScript(
		                "return arguments[0].shadowRoot.querySelector('ion-button[type=\"submit\"]')", 
		                outerShadowHost
		            );
		            return element != null && element.isDisplayed() ? element : null;
		        });

		        // Ensure the button is visible and clickable
		        wait.until(ExpectedConditions.visibilityOf(save));
		        wait.until(ExpectedConditions.elementToBeClickable(save));

		        // Click the save button
		        save.click();
		        System.out.println("Save button clicked successfully.");

		    } catch (NoSuchElementException e) {
		        System.out.println("Element not found: " + e.getMessage());
		        throw new AssertionError("Test failed due to element not found: " + e.getMessage());
		    } catch (Exception e) {
		        System.out.println("An error occurred: " + e.getMessage());
		        throw new AssertionError("Test failed due to unexpected error: " + e.getMessage());
		    }
		}
		
		/*  
		public static void scrollToBottom(WebDriver driver) {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		        // Optional: Wait for an element to load after scrolling (e.g., an input or button in Shadow DOM)
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		     WebElement save =   wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ion-button[type=\\\"submit\\")));
		     save.click();
		    } 
		*/
		
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
		
		
		
		
		/*
		
		
	@Test(priority = 3)
	public void Name() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(getInputField("name")).click();
		driver.findElement(getInputField("name")).clear();
		driver.findElement(getInputField("name")).sendKeys("Latonya Bruno");
		driver.findElement(getInputField("name")).sendKeys(Keys.TAB);
		
	}
	@Test(priority = 4)
	public void Bio() throws InterruptedException {
		
		WebElement bioF = driver.findElement(By.cssSelector("textarea.native-textarea"));
		bioF.click();
		bioF.clear();
		bioF.sendKeys("Passionate about skincare and beauty Ellis is the proud owner of glow & co. , a trusted destination for premium face and skin care productsPassionate about skincare and beauty Ellis is the proud owner of glow & co. , a trusted destination for premium face and skin care products");
	}
	@Test(priority = 5)
	public void Email() {
		WebElement emailF = driver.findElement(By.cssSelector(""));
		emailF.click();
		emailF.clear();
		emailF.sendKeys("test@gmail.com");
	}
	@Test(priority = 6)
	public void Save() {
		WebElement save = driver.findElement(By.cssSelector("ion-button.mt-auto.ion-color.ion-color-secondary"));
		save.click();
	}
}

*/