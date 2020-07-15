package src.cbt_Tests.java.CheckboxesAndDropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import src.cbt_Utilities.java.StringUtility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodaysDate {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement year = driver.findElement(By.id("year"));
        Select years = new Select(year);

        WebElement month = driver.findElement(By.id("month"));
        Select months = new Select(month);

        WebElement day = driver.findElement(By.id("day"));
        Select days = new Select(day);

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy/MMMM/dd");
        LocalDateTime time = LocalDateTime.now();

        StringUtility.verifyEquals(formater.format(time),
                  years.getFirstSelectedOption().getText()+ "/" +
                        months.getFirstSelectedOption().getText()+ "/" +
                        days.getFirstSelectedOption().getText());

        driver.quit();
    }
}
