package testPackage;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;

public class Final {
    public static void main(String[] args)
   {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver(); // Outer scope 'driver'
        driver.get("https://stg-vendor.that-time.co.uk/enter-phone");

//        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Trigger activity to load the Shadow DOM element
            WebElement triggerButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".ng-invalid") // Replace with actual trigger element selector
            ));
            triggerButton.click();

            // Wait for the shadow host to be present
            WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ng-invalid.ng-touched")));

            // Find the phone input inside the Shadow DOM (rename lambda parameter)
            WebElement phoneInput = wait.until(webDriver -> {
                WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript( // Use outer 'driver' here
                    "return arguments[0].shadowRoot.querySelector('.ng-invalid.ng-touched')", 
                    shadowHost
                );
                return element != null && element.isDisplayed() ? element : null;
            });
            phoneInput.sendKeys("123-456-7890");

            // Find and click the "Next" button (rename lambda parameter)
            WebElement nextButton = wait.until(webDriver -> {
                WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript( // Use outer 'driver' here
                    "return arguments[0].shadowRoot.querySelector('.button-inner')", 
                    shadowHost
                );
                return element != null && element.isDisplayed() ? element : null;
            });
            nextButton.click();

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}