package src.cbt_Utilities.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtilities {

    public static WebDriver getDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/Edison/Documents/dependencies/drivers/chromedriver");
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/Edison/Documents/dependencies/drivers/geckodriver");
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge") || browser.equalsIgnoreCase("internet explorer")) {
            System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
            return new EdgeDriver();
        }
        else{
            return null;
        }
    }
}


