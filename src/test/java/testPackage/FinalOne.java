package testPackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FinalOne {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Use WebDriverManager to automatically set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Optional: Maximize the browser window
        wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Wait up to 30 seconds
    }

    @Test
    public void testClickPhoneInput() {
        try {
            // Navigate to the website
            driver.get("https://stg-vendor.that-time.co.uk/enter-phone");
            WebElement triggerButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".ng-invalid") // Replace with actual trigger element selector
                ));
                triggerButton.click();
                triggerButton.sendKeys("7457413014");
                
            // Wait for the phone input to be visible and clickable (assuming it’s in the regular DOM)
            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".control-phone-control input")));
            phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".control-phone-control input")));

            // Debug: Check if phoneInput is found and its state
            System.out.println("Phone input found: " + phoneInput);
            System.out.println("Input visibility: " + ((JavascriptExecutor) driver).executeScript(
                "return getComputedStyle(document.querySelector('.control-phone-control input')).display !== 'none' && " +
                "getComputedStyle(document.querySelector('.control-phone-control input')).visibility !== 'hidden' && " +
                "document.querySelector('.control-phone-control input').style.opacity !== '0'"
            ));
            System.out.println("Input disabled: " + ((JavascriptExecutor) driver).executeScript(
                "return document.querySelector('.control-phone-control input').disabled"
            ));

            // Click on the phone input field
            phoneInput.click();

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            throw new AssertionError("Test failed due to element not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new AssertionError("Test failed due to unexpected error: " + e.getMessage());
        }
    }

//    @AfterClass
//    public void tearDown() {
//        // Clean up: Close the browser
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}