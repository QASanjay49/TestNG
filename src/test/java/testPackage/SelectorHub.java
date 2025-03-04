package testPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectorHub {
	WebDriverWait wait;
	WebDriver drive;


public void setUp() {
    // Use WebDriverManager to automatically set up ChromeDriver
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize(); // Optional: Maximize the browser window
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Reduced to 30 seconds for efficiency (adjust if needed)
    driver.get("https://stg-vendor.that-time.co.uk/enter-phone");
//    JavascriptExecutor js = (JavascriptExecutor) driver;
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
        System.out.println("Shadow root exists: " + ((JavascriptExecutor) drive).executeScript("return arguments[0].shadowRoot", shadowHost));

        // Find the phone input inside the Shadow DOM
        // Updated selector from .ng-invalid.ng-touched to .control-phone-control input (based on screenshot and previous context)
        WebElement phoneInput = wait.until(webDriver -> {
            WebElement element = (WebElement) ((JavascriptExecutor) drive).executeScript(
                "return arguments[0].shadowRoot.querySelector('.ng-invalid')", 
                shadowHost
            );
            // Fallback: Try regular DOM if Shadow DOM fails
            if (element == null) {
                element = drive.findElement(By.cssSelector(".ng-invalid"));
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
            WebElement element = (WebElement) ((JavascriptExecutor) drive).executeScript(
                "return arguments[0].shadowRoot.querySelector('ion-button.ion-color')", 
                shadowHost
            );
            // Fallback: Try regular DOM if Shadow DOM fails
            if (element == null) {
                element = drive.findElement(By.cssSelector("ion-button.ion-color"));
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

public void pass() throws InterruptedException {
	//This Element is inside single shadow DOM.
	String cssSelectorForHost1 = ".item-interactive.item-input.item.md.item-fill-none.ion-focusable.hydrated.item-label.item-label-floating.ion-pristine.ion-invalid.ion-touched.ion-focused.item-has-focus";
	Thread.sleep(1000);
	SearchContext shadow = drive.findElement(By.cssSelector(".item-interactive.item-input.item.md.item-fill-none.ion-focusable.hydrated.item-label.item-label-floating.ion-pristine.ion-invalid.ion-touched.ion-focused.item-has-focus")).getShadowRoot();
	Thread.sleep(1000);
	shadow.findElement(By.cssSelector(".input-wrapper"));
	WebElement Web = shadow.findElement(By.cssSelector(".native-input.sc-ion-input-md"));
	Web.sendKeys("185412451");
}



}