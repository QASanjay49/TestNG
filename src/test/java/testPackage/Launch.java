package testPackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager; // Add this import for WebDriverManager
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Launch {

    WebDriver driver;
    WebDriverWait wait;
    private WebElement outerShadowHost; // Moved to instance variable

    @BeforeClass
    public void setUp() {
        // Use WebDriverManager to automatically set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Optional: Maximize the browser window
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Reduced to 30 seconds for efficiency (adjust if needed)
        driver.get("https://stg-vendor.that-time.co.uk/enter-phone");
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    @Test(priority = 1)
    public void testPhoneInputAndNextButton() {
        try {
            // Removed trigger button logic (.ng-invalid is not a clickable trigger; it’s likely a form validation class)
            
            WebElement triggerButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".ng-invalid") // This is likely incorrect as a trigger
            ));
            triggerButton.click();
            

            // Wait for the shadow host (e.g., ion-content or app-phone-input) to be present
            // Based on previous analysis, ion-content or app-phone-input is likely the Shadow Host
            WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ion-content")));

            // Debug: Check if shadowHost is found and Shadow DOM exists
            System.out.println("Shadow host found: " + shadowHost);
            System.out.println("Shadow root exists: " + ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowHost));

            // Find the phone input inside the Shadow DOM
            // Updated selector from .ng-invalid.ng-touched to .control-phone-control input (based on screenshot and previous context)
            WebElement phoneInput = wait.until(webDriver -> {
                WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].shadowRoot.querySelector('.ng-invalid')", 
                    shadowHost
                );
                // Fallback: Try regular DOM if Shadow DOM fails
                if (element == null) {
                    element = driver.findElement(By.cssSelector(".ng-invalid"));
                }
                return element != null && element.isDisplayed() ? element : null;
            });
            System.out.println("Phone input found: " + phoneInput);
            phoneInput.sendKeys("7457413014"); // Enter a phone number

            // Wait for visibility and clickability to ensure the input is interactable
            wait.until(ExpectedConditions.visibilityOf(phoneInput));
            wait.until(ExpectedConditions.elementToBeClickable(phoneInput));

            // Find and click the "Next" button inside the Shadow DOM
            // Updated selector from .button-inner to button.button-native (based on screenshot)
            WebElement nextButton = wait.until(webDriver -> {
                WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].shadowRoot.querySelector('ion-button.ion-color')", 
                    shadowHost
                );
                // Fallback: Try regular DOM if Shadow DOM fails
                if (element == null) {
                    element = driver.findElement(By.cssSelector("ion-button.ion-color"));
                }
                return element != null && element.isDisplayed() ? element : null;
            });
            System.out.println("Next button found: " + nextButton);

            // Wait for visibility and clickability to ensure the button is interactable
            wait.until(ExpectedConditions.visibilityOf(nextButton));
            wait.until(ExpectedConditions.elementToBeClickable(nextButton));
            nextButton.click();

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            throw new AssertionError("Test failed due to element not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new AssertionError("Test failed due to unexpected error: " + e.getMessage());
        }
    }
    
    @Test(priority = 2)
    public void testPasswordAndLoginButton() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Step 1: Trigger the Activity to Load the Element                                          #ion-input-1-lbl   ion-content[_ngcontent-dgj-c173]
            WebElement tempHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ion-input-1-lbl")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempHost);
            Thread.sleep(2000); // Temporary delay (replace with WebDriverWait if possible)
            System.out.println("TespHost Clicked");

            // Step 2: Set the outer shadow host as an instance variable
            outerShadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ion-content.blur-bg")));
            // Debug: Check if outer shadow host is found and Shadow DOM exists
            System.out.println("Outer shadow host found: " + outerShadowHost);
            System.out.println("Outer shadow root exists: " + ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", outerShadowHost));

            // Step 3: Find the ion-input (inner shadow host) inside ion-content's Shadow DOM
            WebElement innerShadowHost = wait.until(webDriver -> {
                WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].shadowRoot.querySelector('ion-input')", 
                    outerShadowHost // Now an instance variable, no scoping issue
                );
                return element != null && element.isDisplayed() ? element : null;
            });
            System.out.println("Inner shadow host (ion-input) found: " + innerShadowHost);

            // Step 4: Find the password input inside ion-input's Shadow DOM
            WebElement passwordInput = wait.until(webDriver -> {
                WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].shadowRoot.querySelector('input[type=\"password\"].native-input')", 
                    innerShadowHost
                );
                // Fallback: Try regular DOM if nested Shadow DOM fails
                if (element == null) {
                    element = driver.findElement(By.cssSelector("ion-input input[type=\"password\"].native-input"));
                }
                return element != null && element.isDisplayed() ? element : null;
            });
            System.out.println("Password input found: " + passwordInput);

            // Wait for visibility and clickability to ensure the input is interactable
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            wait.until(ExpectedConditions.elementToBeClickable(passwordInput));

            // Enter a password
            passwordInput.sendKeys("YourPassword123"); // Replace with a valid test password (minlength="8")

            // Step 5: Find the ion-button (inner shadow host) inside ion-content's Shadow DOM
            WebElement buttonShadowHost = wait.until(webDriver -> {
                WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].shadowRoot.querySelector('ion-button[type=\"submit\"]')", 
                    outerShadowHost // Now an instance variable, no scoping issue
                );
                return element != null && element.isDisplayed() ? element : null;
            });
            System.out.println("Button shadow host (ion-button) found: " + buttonShadowHost);

            // Step 6: Find the "Log in" button inside ion-button's Shadow DOM
            WebElement loginButton = wait.until(webDriver -> {
                WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].shadowRoot.querySelector('button.button-native')", 
                    buttonShadowHost
                );
                // Fallback: Try regular DOM if nested Shadow DOM fails
                if (element == null) {
                    element = driver.findElement(By.cssSelector("ion-button[type=\"submit\"] button.button-native"));
                }
                return element != null && element.isDisplayed() ? element : null;
            });
            System.out.println("Log in button found: " + loginButton);

            // Wait for visibility and clickability to ensure the button is interactable
            wait.until(ExpectedConditions.visibilityOf(loginButton));
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();

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
}