package pom.Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewBase {
    protected static WebDriver driver; // 🔹 Use static driver to share across tests

    @BeforeSuite
    public void setup() {  // 🔹 Runs ONCE for all tests
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staging.vendor.that-time.co.uk.picl.co.uk/enter-phone");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-invalid")));

        System.out.println("🚀 Browser Launched for Tests");
    }

    @AfterSuite
//    public void teardown() {  // 🔹 Close browser only ONCE at the end
//        if (driver != null) {
//            driver.quit();
//            System.out.println("✅ Browser Closed After Tests");
//        }
//    }

    public WebDriver getDriver() {
        return driver;
    }
    
    public void waitForElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}