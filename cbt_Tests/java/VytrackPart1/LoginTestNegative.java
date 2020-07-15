package src.cbt_Tests.java.VytrackPart1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestNegative {

    WebDriver driver;

    @Test
    public void negativeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");
        driver.findElement(By.id("prependedInput2")).sendKeys("hasdsajhd");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(5000);

        String actualMessage = driver.findElement(By.xpath("//*[@class = 'alert alert-error']")).getText();
        String expectedMessage = "Invalid user name or password.";
        Assert.assertEquals(expectedMessage, actualMessage);

        String currentTitle = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        if(currentTitle.equals(currentUrl)){
            System.out.println("Name of the web page is the same as the title.");
        }
        else{
            System.out.println("Name of the web page is different from the title");
            System.out.println("Title of the webpage: " + currentTitle);
            System.out.println("Url of the webpage: " + currentUrl);
        }
    }
}
