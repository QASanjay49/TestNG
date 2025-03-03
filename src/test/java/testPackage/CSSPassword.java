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

public class CSSPassword extends Launch {

//    WebDriver driver;
    WebDriverWait wait;

//    @BeforeClass
//    public void setUp() {
//        // Use WebDriverManager to automatically set up ChromeDriver
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize(); // Optional: Maximize the browser window
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait up to 30 seconds
//    }

    @Test(priority = 2)
    public void testEnterPasswordAndSubmit() {
        try {
            // Navigate to the website (password page or enter-phone page)
            // driver.get("https://stg-vendor.that-time.co.uk/enter-phone"); // Adjust URL if password page is different
            // Assuming this is called in the base class or not needed if inherited

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Step 1: Trigger the Activity to Load the Element
            // Use a temporary variable to avoid reassigning shadowHost1
            WebElement tempHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ion-content[_ngcontent-dgj-c173]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempHost);
            Thread.sleep(2000); // Temporary delay (replace with WebDriverWait if possible)

            // Step 2: Wait for the shadow host (ion-content) to be present (effectively final)
            WebElement shadowHost1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ion-content[_ngcontent-dgj-c173]")));

            // Debug: Check if shadowHost is found and Shadow DOM exists
            System.out.println("Shadow host found: " + shadowHost1);
            System.out.println("Shadow root exists: " + ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowHost1));

            // Step 3: Find the password input inside the Shadow DOM (effectively final shadowHost1)
            WebElement passwordInput = wait.until(webDriver -> {
                WebElement element2 = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].shadowRoot.querySelector('ion-input input[type=\"password\"]')", 
                    shadowHost1 // Now effectively final, no reassignment
                );
                // Fallback: Try regular DOM if Shadow DOM fails
                if (element2 == null) {
                    element2 = driver.findElement(By.cssSelector("ion-input input[type=\"password\"]"));
                }
                return element2 != null && element2.isDisplayed() ? element2 : null;
            });
            System.out.println("Password input found: " + passwordInput);

            // Wait for visibility and clickability to ensure the input is interactable
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            wait.until(ExpectedConditions.elementToBeClickable(passwordInput));

            // Enter a password
            passwordInput.sendKeys("YourPassword123"); // Replace with a valid test password

            // Step 4: Find and click the "Next" or Submit button inside the Shadow DOM (effectively final shadowHost1)
            WebElement submitButton = wait.until(webDriver -> {
                WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].shadowRoot.querySelector('ion-button[type=\"submit\"]')", 
                    shadowHost1 // Now effectively final, no reassignment
                );
                // Fallback: Try regular DOM if Shadow DOM fails
                if (element == null) {
                    element = driver.findElement(By.cssSelector("ion-button[type=\"submit\"]"));
                }
                return element != null && element.isDisplayed() ? element : null;
            });
            System.out.println("Submit button found: " + submitButton);

            // Wait for visibility and clickability to ensure the button is interactable
            wait.until(ExpectedConditions.visibilityOf(submitButton));
            wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            submitButton.click();

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            throw new AssertionError("Test failed due to element not found: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Wait interrupted: " + e.getMessage());
            throw new AssertionError("Test failed due to wait interruption: " + e.getMessage());
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
    }
