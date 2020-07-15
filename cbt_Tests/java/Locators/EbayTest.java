package src.cbt_Tests.java.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayTest {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://ebay.com");

        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon");
        driver.findElement(By.id("gh-ac")).sendKeys(Keys.ENTER);

        String text = driver.findElement(By.xpath("//*[@class = 'srp-controls__count-heading']")).getText();
        String[] text2 = text.split(" ");
        String number = text2[0].replace(",", "");
        int num = Integer.parseInt(number);

        driver.findElement(By.linkText("All")).click();

        String string = driver.findElement(By.xpath("//*[@class = 'srp-controls__count-heading']")).getText();
        String[] string2 = string.split(" ");
        String numbers = string2[0].replace(",", "");
        int num2 = Integer.parseInt(numbers);

        System.out.println("Number of results before clicking all is: " + num);
        System.out.println("Number of results after clicking all is: " + num2);

        driver.navigate().back();

        String searchText = driver.findElement(By.id("gh-ac")).getAttribute("value");
        System.out.println("Text displayed in search box after navigating back is: " + searchText);

        driver.navigate().back();

        String searchText2 = driver.findElement(By.id("gh-ac")).getAttribute("placeholder");
        System.out.println("Text displayed in search box after navigating back is: " + searchText2);

        driver.quit();
    }
}
