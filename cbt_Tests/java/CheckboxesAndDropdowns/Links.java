package src.cbt_Tests.java.CheckboxesAndDropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Links {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/");
        List<WebElement> tagName = driver.findElements(By.tagName("a"));

        int count = 0;

        for (WebElement each : tagName) {
            if (each.isDisplayed()) {
                System.out.println(count + " ||  " + each.getText());
                System.out.println(count + " ||  " + each.getAttribute("href"));

            }
            count++;
        }

        driver.quit();
    }
}
