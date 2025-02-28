package testPackage;

//public class LoginJS {}

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginJS {
	WebDriver driver;
@Test
public void LOG() throws InterruptedException {
 driver = new ChromeDriver();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

// Open the target URL
driver.get("https://stg-vendor.that-time.co.uk/");

// Maximize window
driver.manage().window().maximize();

waitForPageLoad();
Thread.sleep(1000);


// Wait for page load (use WebDriverWait instead of Thread.sleep)
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='ng-invalid ng-touched']")));


 // Interact with the input field and enter text
   WebElement inputField = driver.findElement(By.xpath("//input[@class='ng-invalid ng-touched']"));
  inputField.sendKeys("7457413014");

//Click next button
//This Element is inside single shadow DOM.
String cssSelectorForHost1 = ".ion-color.ion-color-secondary.md.button.button-block.button-solid.ion-activatable.ion-focusable.hydrated";
Thread.sleep(1000);
SearchContext shadow = driver.findElement(By.cssSelector(".ion-color.ion-color-secondary.md.button.button-block.button-solid.ion-activatable.ion-focusable.hydrated")).getShadowRoot();
Thread.sleep(1000);
shadow.findElement(By.cssSelector(".button-inner")).click();

waitForPageLoad();
Thread.sleep(1000);

 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));

 // Interact with the password field and enter password
 WebElement inputField1 = driver.findElement(By.xpath("//input[@name='password']"));
  inputField1.sendKeys("THATtime321!A");


//This Element is inside single shadow DOM.
String cssSelectorForHost11 = "ion-button[type='submit']";
Thread.sleep(1000);
SearchContext shadow1 = driver.findElement(By.cssSelector("ion-button[type='submit']")).getShadowRoot();
Thread.sleep(1000);
shadow1.findElement(By.cssSelector(".button-inner")).click();

waitForPageLoad();
Thread.sleep(1000);
}

public void waitForPageLoad() {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
JavascriptExecutor js = (JavascriptExecutor) driver;

// Inject network activity tracker
js.executeScript("window.activeNetworkRequests = 0;" + "const originalFetch = window.fetch;"
+ "window.fetch = function() {" + "  window.activeNetworkRequests++;"
+ "  return originalFetch.apply(this, arguments)" + "    .then(response => {"
+ "      window.activeNetworkRequests--;" + "      return response;" + "    })"
+ "    .catch(err => {" + "      window.activeNetworkRequests--;" + "      throw err;"
+ "    });" + "};");
wait.until(driver1 -> {return (Long) js.executeScript("return window.activeNetworkRequests;") == 0;});
}
}