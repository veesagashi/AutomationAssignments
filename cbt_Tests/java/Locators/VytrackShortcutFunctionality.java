package src.cbt_Tests.java.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VytrackShortcutFunctionality {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager101");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        Thread.sleep(10000);

        System.out.println("We are on the " + driver.getTitle() + " page.");

        driver.findElement(By.xpath("//*[@class = 'fa-share-square']")).click();
        driver.findElement(By.linkText("See full list")).click();
        Thread.sleep(5000);

        driver.findElement(By.linkText("Opportunities")).click();
        Thread.sleep(4000);

        System.out.println("We are on the " + driver.findElement(By.xpath("//*[@class = 'oro-subtitle']")).getText()+ " page.");
        System.out.println();

        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@class = 'fa-share-square']")).click();
        driver.findElement(By.linkText("See full list")).click();
        Thread.sleep(5000);

        driver.findElement(By.linkText("Vehicle Services Logs")).click();
        Thread.sleep(5000);
        String message = driver.findElement(By.id("flash-messages")).getText();
        System.out.println("MESSAGE that we got: " + message);

        System.out.println();
        System.out.println("We're still on page: " + driver.getTitle());

        driver.quit();
    }
}
