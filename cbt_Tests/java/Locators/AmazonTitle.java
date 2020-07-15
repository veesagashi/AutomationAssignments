package src.cbt_Tests.java.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AmazonTitle {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Wooden Spoon");
        driver.findElement(By.className("nav-input")).sendKeys(Keys.ENTER);

        String title = driver.getTitle();

        if(title.contains("Wooden Spoon")){
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }

        driver.quit();
    }
}
