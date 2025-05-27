package testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestNG.TestNG.Base;
import utilities.ExcelUtils;

public class NewAppointments extends Base {
/*
    // Locators
    private final By newAppointmentLink = By.xpath("//a[normalize-space()='New Appointment']");
    private final By toggleSwitch = By.cssSelector("div.control.flex.gap-4 span.slider.round");
    private final By chooseClient = By.xpath("//span[text()='Choose a client']");
    private final By searchInput = By.cssSelector("input[placeholder='Search by name, email or number']");
    private final By clientOption = By.xpath("(//button[@class='btn item ion-color-dark w-full px-4 py-2 border-bottom flex items-center gap-4 relative'])[1]");
    private final By selectService = By.xpath("//button[normalize-space()='Select a service']");
    private final By spaService = By.xpath("//h4[normalize-space()='Spa']");
    private final By specificService = By.xpath("//h6[normalize-space()='A1 hair cut & Dye']");
    private final By doneButton = By.xpath("(//button[normalize-space()='Done'])[1]");
    private final By submitButton = By.xpath("//button[normalize-space()='Submit']");
    private final By toastMessage = By.xpath("//div[@class='toast-message']");

    @Test(priority = 3)
    public void createNewAppointment() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Step 1: Navigate to New Appointment page
        wait.until(ExpectedConditions.elementToBeClickable(newAppointmentLink)).click();

        // Step 2: Enable Toggle Switch
        wait.until(ExpectedConditions.elementToBeClickable(toggleSwitch)).click();

        // Step 3: Select client
        wait.until(ExpectedConditions.elementToBeClickable(chooseClient)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys("Evie");
        wait.until(ExpectedConditions.elementToBeClickable(clientOption)).click();

        // Step 4: Select service
        wait.until(ExpectedConditions.elementToBeClickable(selectService)).click();
        wait.until(ExpectedConditions.elementToBeClickable(spaService)).click();
        wait.until(ExpectedConditions.elementToBeClickable(specificService)).click();
        wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();

        // Step 5: Submit appointment
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

        // Step 6: Validate success message
        String expectedMsg = "Appointment created successfully!";
        String actualMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage)).getText().trim();

        Assert.assertEquals(actualMsg, expectedMsg, "❌ Appointment success message mismatch");
        System.out.println("✅ Appointment created successfully with message: " + actualMsg);
    }
    */
	
	
	
	@Test(priority = 3)
	public void createNewAppointment() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='New Appointment']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.control.flex.gap-4 span.slider.round"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Choose a client']"))).click();

	    String clientName = "Evie";
	    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Search by name, email or number']")));
	    searchBox.sendKeys(clientName);
Thread.sleep(4000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn item ion-color-dark w-full px-4 py-2 border-bottom flex items-center gap-4 relative']"))).click();
	    Thread.sleep(4000);

	    
	    
	    
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Select a service']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[normalize-space()='Spa']"))).click();

	    // 4. Get list of services shown on UI
	    List<WebElement> serviceElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h6[contains(@class, 'mr-4')]")));
	    List<String> actualServiceNames = new ArrayList<>();
	    for (WebElement el : serviceElements) {
	        String text = el.getText().trim();
	        actualServiceNames.add(text);
	        System.out.println("UI Service: " + text);
	    }

	    // 5. Read expected service name from Excel
	    String filePath = System.getProperty("user.dir") +"src/test/resources/TestData.xlsx"; // correct path (no leading slash)
	    List<String> expectedServiceNames = ExcelUtils.getExcelData(filePath, "services", 0);
	    if (expectedServiceNames == null || expectedServiceNames.isEmpty()) {
	        throw new RuntimeException("❌ No data loaded from Excel sheet 'services'. Check sheet name, path, or content.");
	    }
	    String expectedService = expectedServiceNames.get(0); // just using first row for now

	    System.out.println("Expected service from Excel: " + expectedService);

	    // 6. Compare & Click on the matching service
	    boolean matched = false;
	    for (WebElement el : serviceElements) {
	        if (el.getText().trim().equalsIgnoreCase(expectedService)) {
	            el.click();
	            System.out.println("✅ Clicked on matched service: " + expectedService);
	            matched = true;
	            break;
	        }
	    }

	    if (!matched) {
	        throw new RuntimeException("❌ Expected service not found in UI: " + expectedService);
	    }

	    // 7. Finish appointment creation
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Done'])[1]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit']"))).click();

	    // 8. Assert success message
	    String expectedMsg = "Appointment created successfully!";
	    String actualMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']"))).getText().trim();

	    Assert.assertEquals(actualMsg, expectedMsg, "❌ Appointment creation message mismatch");
	    System.out.println("✅ Appointment created successfully");
	}
	    
	    
	    
	    
	    
	    /*
  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Select a service']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[normalize-space()='Spa']"))).click();
	    Thread.sleep(4000);

	    List<WebElement> serviceNames = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//h6[contains(@class, 'mr-4')]")));
//	    List<WebElement> serviceNames = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div[@ng-reflect-ng-class='[object Object]'])[35]")));
	    System.out.println(serviceNames);
	    List<String> actualServiceNames= new ArrayList<>();
	    for(WebElement element :serviceNames)
	    {
	    	actualServiceNames.add(element.getText().trim());
	    }
	    String filePath = "/src/test/resources/TestData.xlsx";
	    List<String> expectedServiceNames = ExcelUtils.getExcelData(filePath, "services", 0);
	    
	    		
//	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[normalize-space()='A1 hair cut & Dye']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Done'])[1]"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit']"))).click();

	    String expectedMsg = "Appointment created successfully!";
	    String actualMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']"))).getText().trim();
	    Assert.assertEquals(actualMsg, expectedMsg, "Appointment creation message mismatch");

	    System.out.println("✅ Appointment created successfully");
	}
	*/

}
