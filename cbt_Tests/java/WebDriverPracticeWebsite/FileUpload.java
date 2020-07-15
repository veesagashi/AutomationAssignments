package src.cbt_Tests.java.WebDriverPracticeWebsite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FileUpload {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[@href='/upload']")).click();

        WebElement file = driver.findElement(By.name("file"));
        file.sendKeys("C:\\Users\\Edison\\Desktop\\some-file.txt");
        driver.findElement(By.id("file-submit")).click();

        String actual = driver.findElement(By.xpath("//div[@class='panel text-center']")).getText();
        Assert.assertEquals(actual,"some-file.txt");
    }
}
