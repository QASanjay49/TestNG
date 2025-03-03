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

public class CSSFinal extends Launch {

    WebDriver driver;
    WebDriverWait wait;

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
    
@Test
    public void testPasswordAndLoginButton() {
    	  try {

              WebElement clickButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ion-item.ion-untouched")));
//              ion-item.ion-untouched     input.native-input.sc-ion-input-md
              clickButton.click();

              WebElement shadowHost = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ion-content.blur-bg")));
              System.out.println("Shadow host found: " + shadowHost);
              System.out.println("Shadow root exists: " + ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowHost));

              WebElement passwordInput = wait.until(webDriver -> {
            	  WebElement elements = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot.querySelector('body > app-root > ion-app > ion-router-outlet > app-enter-password > app-outside > ion-content')", shadowHost);
            	  // Fallback: Try regular DOM if Shadow DOM fails
                          if (elements == null) {
                              elements = driver.findElement(By.cssSelector("body > app-root > ion-app > ion-router-outlet > app-enter-password > app-outside > ion-content"));
                          }
                          return elements != null && elements.isDisplayed() ? elements : null;
                      });
              System.out.println("password input fields found" +passwordInput);
              passwordInput.sendKeys("THATtime321!A");
    	
           // Wait for visibility and clickability to ensure the input is interactable
              wait.until(ExpectedConditions.visibilityOf(passwordInput));
              wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
             
              WebElement loginButton = wait.until(webDriber -> { 
            	  WebElement loginElement = (WebElement)((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot.querySelector('ion-button.ion-color')" , shadowHost);
              if(loginElement == null) {
            	  loginElement = driver.findElement(By.cssSelector("ion-button.ion-color"));
              }
              return loginElement != null && loginElement.isDisplayed() ? loginElement : null;
              });
              System.out.println("Login button is found"+loginButton);
              wait.until(ExpectedConditions.visibilityOf(loginButton));
              wait.until(ExpectedConditions.elementToBeClickable(loginButton));
              loginButton.click();
    	  
    } catch (NoSuchElementException e) {
        System.out.println("Element not found: " + e.getMessage());
        throw new AssertionError("Test failed due to element not found: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
        throw new AssertionError("Test failed due to unexpected error: " + e.getMessage());
    }
}
    }
