package src.cbt_Tests.java.CheckboxesAndDropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Departments {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/gp/site-directory");

        WebElement selectDepartment = driver.findElement(By.xpath("//select"));
        Select depts = new Select(selectDepartment);

        List<WebElement> options = depts.getOptions();
        List<String> textOptions = new ArrayList<>();

        for (WebElement option : options) {
            textOptions.add(option.getText());
        }
        List<WebElement> headers = driver.findElements(By.className("fsdDeptTitle"));

        for (WebElement header : headers) {
            String headersText = header.getText();

            if (textOptions.contains(headersText)) {
                System.out.println("PASS: This header " + headersText + " is found on categories.");
            } else {
                System.out.println("FAIL: This header " + headersText + " cannot be found on categories.");
            }
        }

        driver.quit();
    }
}
