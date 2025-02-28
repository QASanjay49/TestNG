package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import TestNG.TestNG.Base;

public class MyBio extends Base {





    // Dynamic method to get input fields
    public By getInputField(String fieldName) {
        return By.xpath(String.format("//input[@name='%s']", fieldName));
    }

    @Test(priority = 3)
    public void updateProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Define input values for different fields
        String[][] fields = {
            {"name", "Rajesh"},
            {"bio", "Passionate about skincare and beauty. Owner of Glow & Co."},
            {"email", "rajesh@example.com"},
//            {"phone", "9876543210"}
        };

        for (String[] field : fields) {
            String fieldName = field[0];
            String fieldValue = field[1];

            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(getInputField(fieldName)));
            inputField.click();
            inputField.clear();
            inputField.sendKeys(fieldValue);

            System.out.println(fieldName + " updated successfully!");
//            inputField.sendKeys(Keys.TAB);
            
        }
    }
}
