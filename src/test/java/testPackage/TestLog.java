package testPackage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestLog {
  private WebDriver driver;
  private WebDriverWait wait;
  private static final int WAIT_TIMEOUT = 60;
  private static final String BASE_URL = "https://stg-vendor.that-time.co.uk/";

  @BeforeTest
  public void setup() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
    driver.manage().window().maximize();
  }
@Test
public void loginTest() {
    try {
      // Navigate to the website
      driver.get(BASE_URL);
      waitForPageLoad();

      // Login process
      loginToApplication("7457413014", "THATtime321!A");

      // Navigate through menu
      navigateToServices();

    } catch (Exception e) {
      throw new RuntimeException("Test failed: " + e.getMessage());
    }
  }

  private void loginToApplication(String username, String password) {
    // Enter username
    waitAndSendKeys("//input[@class='ng-invalid ng-touched']", username);

    // Click next button
    clickShadowDomElement(".ion-color.ion-color-secondary.md.button.button-block.button-solid.ion-activatable.ion-focusable.hydrated", ".button-inner");

    // Enter password
    waitAndSendKeys("//input[@name='password']", password);

    // Click submit button
    clickShadowDomElement("ion-button[type='submit']", ".button-inner");
  }

  private void navigateToServices() {
    // Click Menu
    waitAndClick("//span[normalize-space()='Menu']");

    // Click My Profile
    waitAndClick("//ion-card-title[normalize-space()='My Profile']");

    // Click Services
    waitAndClick("//app-modal-container[@ng-reflect-footer='false']//ion-label[normalize-space()='Services']");
  }

  private void waitAndSendKeys(String xpath, String text) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)))
      .sendKeys(text);
  }

  private void waitAndClick(String xpath) {
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))
      .click();
    waitForPageLoad();
  }

  private void clickShadowDomElement(String hostSelector, String shadowSelector) {
    try {
      SearchContext shadow = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.cssSelector(hostSelector))).getShadowRoot();
      shadow.findElement(By.cssSelector(shadowSelector)).click();
      waitForPageLoad();
    } catch (Exception e) {
      throw new RuntimeException("Failed to interact with shadow DOM element: " + e.getMessage());
    }
  }

  public void waitForPageLoad() {
    WebDriverWait pageLoadWait = new WebDriverWait(driver, Duration.ofSeconds(120));
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // Inject network activity tracker
    js.executeScript(
      "window.activeNetworkRequests = 0;" +
      "const originalFetch = window.fetch;" +
      "window.fetch = function() {" +
      "  window.activeNetworkRequests++;" +
      "  return originalFetch.apply(this, arguments)" +
      "    .then(response => {" +
      "      window.activeNetworkRequests--;" +
      "      return response;" +
      "    })" +
      "    .catch(err => {" +
      "      window.activeNetworkRequests--;" +
      "      throw err;" +
      "    });" +
      "};"
    );

    pageLoadWait.until(driver1 ->
      (Long) js.executeScript("return window.activeNetworkRequests;") == 0
    );
  }
}