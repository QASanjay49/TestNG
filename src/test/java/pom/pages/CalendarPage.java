package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {
	@FindBy(xpath = "//a[normalize-space()='New Appointment']")
	private WebElement newAppointment;
	
	@FindBy(xpath= "//a[normalize-space()='Generate Link']")
	private WebElement generateLink;
	@FindBy(xpath= "//button[normalize-space()='Block a Time']")
	private WebElement blockATime;
	
	@FindBy(xpath="//button[normalize-space()='Unblock a Time']")
	private WebElement unblockATime;

	private WebDriver driver;
	
	public CalendarPage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver,this);
	 }
	public void clickNewAppointment() {
		newAppointment.click();
	}
	public void clickGenerateLink() {
		generateLink.click();
	}
	public void clickBlockATime() {
		blockATime.click();
	}
	public void clickUnblockATime() {
		unblockATime.click();
	}
}
