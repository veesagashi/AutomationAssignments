package src.cbt_Tests.java.CheckboxesAndDropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ValidLinks {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/documentation/en/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for (int i = 0; i < allLinks.size(); i++) {
            String href = allLinks.get(i).getAttribute("href");
            try {
                URL url = new URL(href);
                HttpURLConnection httpURL = (HttpURLConnection) url.openConnection();
                httpURL.setConnectTimeout(3000);
                httpURL.connect();

                Assert.assertEquals(httpURL.getResponseCode(), 200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
