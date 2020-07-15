package src.cbt_Tests.java.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaUrl {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://wikipedia.org");

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//button[@* = 'pure-button pure-button-primary-progressive']")).click();
        driver.findElement(By.partialLinkText("(software)")).click();

        if(driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }

        driver.quit();
    }
}
