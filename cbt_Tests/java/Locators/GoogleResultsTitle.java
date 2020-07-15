package src.cbt_Tests.java.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import src.cbt_Utilities.java.*;

import java.util.Arrays;
import java.util.List;

public class GoogleResultsTitle {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation");

        for(String url : searchStrs){
             driver.findElement(By.xpath("//*[@class = 'gLFyf gsfi']")).sendKeys("java");
             driver.findElement(By.xpath("//*[@class = 'gLFyf gsfi']")).sendKeys(Keys.ENTER);

             String headUrl = driver.findElement(By.xpath("//*[@class = 'iUh30 tjvcx']")).getText();

             driver.findElement(By.name("r")).sendKeys(Keys.ENTER);
             String currentUrl = driver.getCurrentUrl();

             StringUtility.verifyEquals(headUrl, currentUrl);

             driver.navigate().back();
        }
    }
}
