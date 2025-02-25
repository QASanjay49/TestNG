package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import TestNG.TestNG.Base;

//public class Login extends Base {
//
//    @Test(priority = 1)  // 🔹 Ensure Login runs FIRST
    public class Login extends Base {

        @Test(dataProvider = "LoginData", dataProviderClass = utils.TestDataProvider.class)
        public void LoginData(String phone, String password) throws InterruptedException {
        	 Thread.sleep(5000);

            driver.findElement(By.className("ng-invalid")).sendKeys(phone);
            driver.findElement(By.className("ion-color")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
           // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("native-input")));
            Thread.sleep(10000);
            driver.findElement(By.className("native-input")).sendKeys(password);
            driver.findElement(By.xpath("//ion-button[@type='submit']")).click();
            Thread.sleep(10000);

//            driver.findElement(By.className("button-native")).click();
            
        }
    }