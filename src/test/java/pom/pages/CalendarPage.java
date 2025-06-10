package pom.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarPage {
	WebDriver driver;
	
//	New Appointment
	@FindBy(xpath = "//a[normalize-space()='New Appointment']")
	private WebElement newAppointment;
	@FindBy(css = "div.control.flex.gap-4 span.slider.round")
	private WebElement walkIn;
	@FindBy(xpath = "//span[text()='Choose a client']")
	private WebElement chooseAClient;
	@FindBy(xpath= "//ul[@class='list-none m-0 p-0']")
	private WebElement optionsList;
	
	@FindBy (css = "input[placeholder='Search by name, email or number']")
	private WebElement searchByName;
	@FindBy(xpath = "//button[@class='btn item ion-color-dark w-full px-4 py-2 border-bottom flex items-center gap-4 relative']")
	private WebElement selectOptions;
	@FindBy(xpath = "//button[normalize-space()='Select a service']")
	private WebElement selectAService;
	@FindBy(xpath = "//h4[normalize-space()='Spa']")
	private WebElement spa;
	
//	Generate Link
	@FindBy(xpath= "//a[normalize-space()='Generate Link']")
	private WebElement generateLink;
	
//	Block A Time
	@FindBy(xpath= "//button[normalize-space()='Block a Time']")
	private WebElement blockATime;
	
//	Unblock A Time
	@FindBy(xpath="//button[normalize-space()='Unblock a Time']")
	private WebElement unblockATime;
	
	public CalendarPage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver,this);
	 }
	public void clickNewAppointment() {
		newAppointment.click();
	}
	public void allOptions() {
		chooseAClient.click();
		List<WebElement> options = optionsList.findElements(By.tagName("li"));
		 for (WebElement option : options) {
	            System.out.println(option.getText().trim());
		 }
	        
	}
	/*
	public List<String> getDisplayedOptions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ulElement = wait.until(ExpectedConditions.visibilityOfElementLocated(optionsList));
        List<WebElement> options = ulElement.findElements(optionItems);

        List<String> optionTexts = new ArrayList<>();
        for (WebElement option : options) {
            optionTexts.add(option.getText().trim());
        }
        return optionTexts;
    }*/
	
	
	
	
	public void walkInButton(){
		walkIn.click();
	}
	public void clientName() {
		chooseAClient.click();
			}
	public void trail(String name) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		walkIn.click();
		chooseAClient.click();
		searchByName.sendKeys(name);
		selectOptions.click();
		
	}
	public void clientNameSearch(String name) {
		searchByName.sendKeys(name);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='font-medium'][contains(text(), '\" + name + \"')]")
		      //div[@class='font-medium'][normalize-space()='"+ name + "']
		        
		      //div[@class='font-medium'][contains(text(), '" + name + "')]
//		    ));

		    // Now click on the suggestion
//		    WebElement clientOption = driver.findElement(By.xpath("//div[@class='font-medium'][contains(text(), '\" + name + \"')]"));
		   
//		    clientOption.click();
//		    wait.until(ExpectedConditions.elementToBeClickable(clientOption));

		
	}
	public void selectClientFromOptions() throws InterruptedException {
		Thread.sleep(5000);
		selectOptions.click();
	}
	public void services() {
		
		
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
