package testcases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestNG.TestNG.Base;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class NestedShadowDOMExample extends Base {


public NestedShadowDOMExample() {
        // Set up WebDriver (Ensure ChromeDriver is correctly set up)
//        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Open the website
//        driver.get("YOUR_PAGE_URL");  // Replace with actual URL

        // Wait until the page loads
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // Access Shadow DOM elements using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Locate the First Shadow Host
        WebElement firstShadowHost = driver.findElement(By.cssSelector("ion-content")); 
        WebElement firstShadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", firstShadowHost);

        // Locate the Second Shadow Host inside the first Shadow DOM
        WebElement secondShadowHost = firstShadowRoot.findElement(By.cssSelector("div.modal-container"));  
        WebElement secondShadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", secondShadowHost);

        // Locate the Third Shadow Host inside the second Shadow DOM
        WebElement thirdShadowHost = secondShadowRoot.findElement(By.cssSelector("form"));
        WebElement thirdShadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", thirdShadowHost);
        
        // Find and clear "Name" field inside the deepest Shadow DOM
        WebElement nameField = thirdShadowRoot.findElement(By.cssSelector("input[name='name']"));
        nameField.click();
        nameField.clear();
        nameField.sendKeys("John Doe");

        // Find and clear "Bio" field inside the deepest Shadow DOM
        WebElement bioField = thirdShadowRoot.findElement(By.cssSelector("textarea[name='bio']"));
        bioField.click();
        bioField.clear();
        bioField.sendKeys("Software Engineer with a passion for automation.");

        // Find and clear "Email" field inside the deepest Shadow DOM
        WebElement emailField = thirdShadowRoot.findElement(By.cssSelector("input[name='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("johndoe@example.com");

        System.out.println("Profile updated successfully!");

        // Close the browser
//        driver.quit();
    }
}
