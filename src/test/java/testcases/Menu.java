package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import TestNG.TestNG.Base;

public class Menu extends Base {
	
	
	public By getMenuEle(String menuName) {
		return By.xpath(String.format("//span[text()='%s']", menuName));
	}
    

    @Test(priority = 2)
    public void clickMenuTab() throws InterruptedException {
    	
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//    	
//        // Step 1: Get shadow root of ion-router-outlet
//        WebElement shadowHost1 = wait.until(ExpectedConditions.presenceOfElementLocated(
//            By.cssSelector("ion-router-outlet.hydrated[ng-reflect-animated='false']")));
//        SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
//
//        // Step 2: Get shadow root of ion-tab-bar
//        WebElement shadowHost2 = wait.until(ExpectedConditions.presenceOfElementLocated(
//            By.cssSelector("ion-tab-bar.md.hydrated[role='tablist']")));
//        SearchContext shadowRoot2 = shadowHost2.getShadowRoot();
//
//        // Step 3: Get shadow root of ion-tab-button with id 'tab-button-shop'
//        WebElement shadowHost3 = wait.until(ExpectedConditions.presenceOfElementLocated(
//            By.cssSelector("ion-tab-button#tab-button-shop")));
//        SearchContext shadowRoot3 = shadowHost3.getShadowRoot();
//
//        // Step 4: Locate and click the "Menu" button
//        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(
//            shadowRoot3.findElement(By.xpath("//span[normalize-space()='Menu']"))));
//        menuButton.click();
        
        Thread.sleep(2000);
        driver.findElement(getMenuEle("Menu")).click();
        Thread.sleep(4000);
        
        
        
//        driver.findElement(getMenuEle("Calendar")).click();
//        Thread.sleep(2000);
        WebElement ele = driver.findElement(By.xpath("//ion-card-title[normalize-space()='My Profile']"));
        Actions ob = new Actions(driver);
        ob.moveToElement(ele);
        ob.click(ele);
        Action action  = ob.build();
        action.perform();
        Thread.sleep(2000);
        System.out.println("Successfully clicked the 'Menu' button!");
    	
    	
    	
    	
    	

//        try {
//          
//
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//            finally {
//            // Close the browser after execution
//            driver.quit();
//        }
    }
}
    	
    	
//    	
//    }
//    	
//    	//This Element is inside single shadow DOM.
//    	String cssSelectorForHost1 = "#tab-button-shop";
//    	Thread.sleep(50000);
//    	SearchContext shadow = driver.findElement(By.cssSelector("#tab-button-shop")).getShadowRoot();
//    	Thread.sleep(50000);
//    	shadow.findElement(By.cssSelector(".button-inner")).click();
//    }
//        
//        String cssSelectorForHost1 = "ion-router-outlet.hydrated[ng-reflect-animated=\"false\"]";
//        String cssSelectorForHost2 = "ion-tab-bar.md.hydrated";
//        String cssSelectorForHost3 = "#tab-button-shop";
//
//        // Wait for shadow root to be available
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        
//        // Get first shadow root
//        WebElement shadowHost1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelectorForHost1)));
//        SearchContext shadow0 = shadowHost1.getShadowRoot();
//        
//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
//
//        // Get second shadow root
//        WebElement shadowHost2 = shadow0.findElement(By.cssSelector(cssSelectorForHost2));
//        // No shadow root if ion-tab-bar isn't a shadow host
//        SearchContext shadow1 = shadowHost2.getShadowRoot();
//        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
//
//        // Get the menu button
//        WebElement menuButton = shadow1.findElement(By.cssSelector(cssSelectorForHost3));
//        
//        // Wait for Menu button and click
//        WebElement menuElement = wait.until(ExpectedConditions.elementToBeClickable(menuButton));
//        menuElement.click();
//    }

//    public void clickMenuTab() throws InterruptedException {
//    	
//    	
//    	String cssSelectorForHost1 = "ion-router-outlet.hydrated[ng-reflect-animated=\"false\"]";
//        String cssSelectorForHost2 = "ion-tab-bar.md.hydrated";
//        String cssSelectorForHost3 = "#tab-button-shop";
//        Thread.sleep(10000); 
//        SearchContext shadow0 = driver.findElement(By.cssSelector("ion-router-outlet.hydrated[ng-reflect-animated=\"false\"]")).getShadowRoot(); 
//        Thread.sleep(10000); 
//        SearchContext shadow1 = shadow0.findElement(By.cssSelector("ion-tab-bar.md.hydrated")).getShadowRoot(); 
//        Thread.sleep(10000); 
//        SearchContext shadow2 = shadow0.findElement(By.cssSelector("#tab-button-shop")).getShadowRoot(); 
//        Thread.sleep(10000);
//        shadow1.findElement(By.cssSelector("#pizza")).sendKeys("cheese");
//        shadow2.findElement(By.xpath("//span[normalize-space()='Menu']")).click();
    	
    	
    	
    	
    	
//    	
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        
//      //This Element is inside single shadow DOM.
//        String cssSelectorForHost1 = "#tab-button-shop";
//        Thread.sleep(10000);
//        SearchContext shadow = driver.findElement(By.cssSelector("#tab-button-shop")).getShadowRoot();
//        Thread.sleep(10000);
//        shadow.findElement(By.cssSelector(".button-inner"));
//    }
    
    
    
  //This Element is inside 2 nested shadow DOM. 
    
    
    
    
//  //This Element is inside single shadow DOM.
//    String cssSelectorForHost1 = "#tab-button-shop";
//    Thread.sleep(1000);
//    SearchContext shadow = driver.findElement(By.cssSelector("#tab-button-shop")).getShadowRoot();
//    Thread.sleep(1000);
//    shadow.findElement(By.cssSelector(".button-inner"));
    
        
        
//      //This Element is inside 2 nested shadow DOM. 
//        String pssSelector ForHost1 = "#userName"; 
//        String cssSelector ForHost2 = "#app2"; 
//        Thread.sleep(1000); 
//        SearchContext shadow0 = driver.findElement(By.cssSelector("#userName")).getShadowRoot(); 
//        Thread.sleep(1000); 
//        SearchContext shadow1 = shadow0.findElement(By.cssSelector("#app2")).getShadowRoot(); 
//        Thread.sleep(1000); 
//        shadow1.findElement(By.cssSelector("#pizza")).sendKeys("cheese");
//        
        
        
//
//        try {
//            // Step 1: Locate `app-tabs`
//        	Thread.sleep(10000);
//            WebElement shadowHost = wait.until(
//                ExpectedConditions.presenceOfElementLocated(By.cssSelector("app-tabs")));
//            Thread.sleep(10000);
//            // Step 2: Retrieve Shadow Root using JavaScript
//            WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
//
//            if (shadowRoot == null) {
//                throw new NullPointerException("❌ Shadow Root not found for 'app-tabs'!");
//            }
//
//            // Step 3: Locate 'Menu' tab inside Shadow DOM
//            WebElement menuTab = shadowRoot.findElement(By.cssSelector("ion-tab-button[tab='shop']"));
//
//            // Step 4: Click on 'Menu' tab
//            menuTab.click();
//
//            System.out.println("✅ Clicked on 'Menu' tab successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("❌ Error clicking 'Menu' tab: " + e.getMessage());
//        }
//    }
    
    
    
    
//    @Test(priority = 3)
//    public void fillProfileDetails() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ion-card-title[normalize-space()='My Profile']")));
//
//      //This Element is inside single shadow DOM.
//        String cssSelectorForHost1 = "#tab-button-shop";
//        Thread.sleep(10000);
//        SearchContext shadow = driver.findElement(By.cssSelector("#tab-button-shop")).getShadowRoot();
//        Thread.sleep(1000);
//        shadow.findElement(By.cssSelector(".button-inner"));
//        
//      driver.findElement(By.xpath("//ion-label[normalize-space()='My Profile']")).click();
//        
//       driver.findElement(By.xpath("//ion-card-title[normalize-space()='My Profile']")).click();
//        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Jack R");
//        driver.findElement(By.xpath("//textarea[@name='bio']")).sendKeys("Passionate about skincare and beauty...");
//        driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("01-02-2025");
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jackr@yopmail.com");
//        WebElement form = driver.findElement(By.xpath("//span[@class='button-inner']"));
//        form.submit();
//        System.out.println("✅ Profile Details Submitted");
//    }
//}
