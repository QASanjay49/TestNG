package pom.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private WebElement getMenuElement(String menuName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(String.format("//span[text()='%s']", menuName))));
	}

	public void clickMenu(String menuName) {
		getMenuElement(menuName).click();
	}

	public void clickHomePage() {
		clickMenu("Home");
	}

	public void clickAnalyticsPage() {
		clickMenu("Analytics");
	}

	public void clickCaledarPage() {
		clickMenu("Calendar");
	}

	public void clickNotificationsPage() {
		clickMenu("Notifications");
	}

	public void clickMenuPage() {
		clickMenu("Menu");
	}
}
