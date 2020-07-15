package src.cbt_Tests.java.CheckboxesAndDropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class Days {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("td input"));
        List<WebElement> labels = driver.findElements(By.cssSelector("td label"));

        Random random = new Random();

        int count = 0;

        while(count != 3) {
            int num = random.nextInt(checkboxes.size()-1);
            if(checkboxes.get(num).isEnabled()){
                if(labels.get(num).getText().equals("Friday")) {
                    count++;
                }
                checkboxes.get(num).click();

                System.out.println(labels.get(num).getText());

                checkboxes.get(num).click();
            }
        }
        driver.quit();
    }
}
