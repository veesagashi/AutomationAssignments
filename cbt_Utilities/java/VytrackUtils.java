package src.cbt_Utilities.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class VytrackUtils {

    public static void login(WebDriver driver, String username, String password){
        driver.findElement(By.id("prependedInput")).
                sendKeys(username);

        driver.findElement(By.id("prependedInput2")).
                sendKeys(password+ Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs("Dashboard"));

    }
}
