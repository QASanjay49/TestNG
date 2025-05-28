package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	WebDriver driver;
 @FindBy(className="ng-invalid")
 private WebElement mobileNumber;
 
 @FindBy(className="ion-color")
 private WebElement next;
 
 @FindBy(className="native-input")
 private WebElement loginPassword;
 
 @FindBy(xpath="//ion-button[@type='submit']")
 private WebElement submit;
 
 public LogInPage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver,this);
 }
 
 public void enterNumber(String number) {
	 mobileNumber.sendKeys(number);
 }
 public void click() {
	 next.click();
 }
 public void enterPassword(String password) {
	 loginPassword.sendKeys(password);
 }
 public void logIn() {
	 submit.click();
 }
}
