
	
	package testcases;

	import java.time.Duration;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	import TestNG.TestNG.Base;

	public class NewAppoint extends Base {/*
	    private By newAppointmentLink = By.xpath("//a[normalize-space()='New Appointment']");
	    private By toggleSwitch = By.cssSelector("div.control.flex.gap-4 span.slider.round");
	    private By chooseClient = By.xpath("//span[text()='Choose a client']");
	    private By searchInput = By.cssSelector("input[placeholder='Search by name, email or number']");
	    private By clientOption = By.xpath("(//button[@class='btn item ion-color-dark w-full px-4 py-2 border-bottom flex items-center gap-4 relative'])[1]");
	    private By selectService = By.xpath("//button[normalize-space()='Select a service']");
	    private By spaService = By.xpath("//div[normalize-space()='Spa']");
	    private By specificService = By.xpath("//h6[normalize-space()='A1 hair cut & Dye']");
	    private By doneButton = By.xpath("(//button[normalize-space()='Done'])[1]");
	    private By submitButton = By.xpath("//button[normalize-space()='Submit']");
	    private By successMessage = By.xpath("//div[text()='OK']");// Toaster message is not found 


	    @Test
	    public void createNewAppointment() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(newAppointmentLink)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(toggleSwitch)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(chooseClient)).click();
	        
	        String clientName = "Evie"; // Ideally, read from ExcelUtils
	        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(clientName);
	        wait.until(ExpectedConditions.elementToBeClickable(clientOption)).click();
	        
	        wait.until(ExpectedConditions.elementToBeClickable(selectService)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(spaService)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(specificService)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	        
	        String expectedMsg = "Appointment created successfully!";
	        String actualMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText().trim();
	        Assert.assertEquals(actualMsg, expectedMsg, "Appointment creation message mismatch");
	        System.out.println("✅ Appointment created successfully");
	    }
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(priority=3)
	public void NewAppointment() throws InterruptedException {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	Thread.sleep(5000);
	//click on the new appointment 
	driver.findElement(By.xpath("//a[ normalize-space()='New Appointment']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='control flex gap-4']//span[@class='slider round']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()=\"Choose a client\"]")).click();	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	String clientName = "Evie";
	WebElement sample = driver.findElement(By.xpath("//input[@placeholder='Search by name, email or number']"));
	sample.sendKeys(clientName);
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//button[@class='btn item ion-color-dark w-full px-4 py-2 border-bottom flex items-center gap-4 relative'])[1]")).click();
	
	
	
	

	
	
	
	
//	Select services
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[ normalize-space()='Select a service']")).click();
	
	Thread.sleep(4000);
	driver.findElement(By.xpath("//h4[normalize-space()='Spa']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//h6[normalize-space()='A1 hair cut & Dye']")).click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("(//button[normalize-space()='Done'])[1]")).click();

//	driver.findElement(By.xpath("//button[class='btn solid ion-color-secondary w-full']"));
//	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	String expectedMsg = "Appointment created successfully!";
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	String actualMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"toast-message\"]"))).getText();
//	String actualMsg = driver.findElement(By.xpath("//ion-toast[@class=\"ion-color.ion-color-success.md.hydrated\"]")).getText();
	System.out.println(actualMsg.trim());
	Assert.assertEquals(expectedMsg, actualMsg, "actual msg is not matching with expected msg");
	System.out.println("actual = expected");
	
	Thread.sleep(5000);
	}
	}


