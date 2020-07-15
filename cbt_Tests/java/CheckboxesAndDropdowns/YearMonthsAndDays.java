package src.cbt_Tests.java.CheckboxesAndDropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class YearMonthsAndDays {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement days = driver.findElement(By.id("day"));
        Select nrOfDays = new Select(days);
        int day = nrOfDays.getOptions().size();
        System.out.println("The number of days this month has is " + day);

        Random random = new Random();

        WebElement years = driver.findElement(By.id("year"));
        Select year = new Select(years);
        year.selectByIndex(random.nextInt(year.getOptions().size()-1));
        int rYear = Integer.parseInt(year.getFirstSelectedOption().getText());
        System.out.println("The year that we selected is " + year.getFirstSelectedOption().getText());

        boolean lYear = false;

        if (rYear % 4 == 0 && ( rYear % 100 != 0 || rYear % 400 == 0 ) ) {
            lYear = true;
            System.out.println("This is a leap year!");
        } else {
            System.out.println("This is not a leap year!");
        }

        WebElement month = driver.findElement(By.id("month"));
        Select months = new Select(month);

        for(int i = 0; i < months.getOptions().size(); i++) {
            months.selectByIndex(i);
            nrOfDays = new Select(days);
            int daysOfTheMonth = nrOfDays.getOptions().size();

            if(lYear == true && months.getFirstSelectedOption().getText().equals("February")) {
                System.out.println(months.getFirstSelectedOption().getText() +
                        " has " + daysOfTheMonth + " days, because this is a leap year.");
            }
            if(day == daysOfTheMonth) {
                System.out.println("PASS: " +
                        months.getFirstSelectedOption().getText() +
                        " has the same number of days(" + daysOfTheMonth +
                        ") as our current month(" + day +").");
            } else {
                System.out.println("FAIL: " +
                        months.getFirstSelectedOption().getText() +
                        " doesn't have the same number of days(" + daysOfTheMonth +
                        ") as our current month(" + day +").");
            }
        }

        driver.quit();
    }
}
