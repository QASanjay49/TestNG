package pom.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.pages.DashboardPage;

public class DashboardTest extends LogInTest {

	DashboardPage dashboardpage;

	@BeforeMethod
	public void setUpDashboardPage() {

		dashboardpage = new DashboardPage(driver);

	}

	public void Home() {

	}

	public void Analitics() {
		dashboardpage.clickAnalyticsPage();
	}

	@Test(priority=2)
	public void Calendar() {
		
		dashboardpage.clickCaledarPage();
	}

	public void Notifications() {
		dashboardpage.clickNotificationsPage();
	}

	public void Menu() {
		dashboardpage.clickMenuPage();
	}

}
