package src.cbt_Tests.java.WebDriverPracticeWebsite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Autocomplete {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.cssSelector("[href='/autocomplete']")).click();

        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("input[type='button']")).click();

        WebElement text = driver.findElement(By.id("result"));
        Assert.assertTrue(text.isDisplayed());
    }
}
