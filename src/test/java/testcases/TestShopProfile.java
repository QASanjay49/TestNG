package testcases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestShopProfile {
    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void testShadowDOM() throws Exception {
        try {
            // Set up WebDriver
//            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(60));

            // Open the website
            //driver.get("YOUR_PAGE_URL");  // Replace with actual URL

            // Wait until the page loads
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

            // Access Shadow DOM elements using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(10000);
            // Locate the First Shadow Host
            WebElement firstShadowHost = driver.findElement(By.cssSelector("ion-content")); 
            WebElement firstShadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", firstShadowHost);
            Thread.sleep(10000);
            // Locate the Second Shadow Host inside the first Shadow DOM
            WebElement secondShadowHost = firstShadowRoot.findElement(By.cssSelector("div.modal-container"));  
            WebElement secondShadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", secondShadowHost);
            Thread.sleep(10000);
            // Locate the Third Shadow Host inside the second Shadow DOM
            WebElement thirdShadowHost = secondShadowRoot.findElement(By.cssSelector("form"));
            WebElement thirdShadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", thirdShadowHost);
            Thread.sleep(10000);
            // Find and fill "Name" field
            WebElement nameField = thirdShadowRoot.findElement(By.cssSelector("input[name='name']"));
            nameField.click();
            nameField.clear();
            nameField.sendKeys("John Doe");

            // Find and fill "Bio" field
            WebElement bioField = thirdShadowRoot.findElement(By.cssSelector("textarea[name='bio']"));
            bioField.click();
            bioField.clear();
            bioField.sendKeys("Software Engineer with a passion for automation.");

            // Find and fill "Email" field
            WebElement emailField = thirdShadowRoot.findElement(By.cssSelector("input[name='email']"));
            emailField.click();
            emailField.clear();
            emailField.sendKeys("johndoe@example.com");

            System.out.println("Profile updated successfully!");
        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            throw e;
        } finally {
            // Clean up
//            if (driver != null) {
//                driver.quit();
//            }
        }
    }
}