package src.cbt_Tests.java.CheckboxesAndDropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DepartmentSort {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        WebElement selectDepartment = driver.findElement(By.xpath("//select"));
        Select depts = new Select(selectDepartment);

        List<WebElement> options = depts.getOptions();

        for (int i = 1; i < options.size() - 1; i++) {

            String currentDept = options.get(i).getText();
            String nextDept = options.get(i + 1).getText();

            System.out.println("Comparing: " + currentDept + " " + nextDept);

            if (currentDept.compareTo(nextDept) < 0) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        }

        driver.quit();
    }
}
