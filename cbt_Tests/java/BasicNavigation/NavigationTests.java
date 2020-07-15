package src.cbt_Tests.java.BasicNavigation;

import org.openqa.selenium.WebDriver;
import src.cbt_Utilities.java.*;

public class NavigationTests {
    public static void main(String[] args){
        chromeTest();
        firefoxTest();
        edgeTest();
    }

    public static void chromeTest(){
        WebDriver driver = BrowserUtilities.getDriver("chrome");

        driver.get("https://google.com");
        String title = driver.getTitle();

        driver.get("https://etsy.com");
        String title2 = driver.getTitle();

        driver.navigate().back();
        StringUtility.verifyEquals(title, driver.getTitle());

        driver.navigate().forward();
        StringUtility.verifyEquals(title2, driver.getTitle());
    }

    public static void firefoxTest(){
        WebDriver driver = BrowserUtilities.getDriver("firefox");

        driver.get("https://google.com");
        String title = driver.getTitle();

        driver.get("https://etsy.com");
        String title2 = driver.getTitle();

        driver.navigate().back();
        StringUtility.verifyEquals(title, driver.getTitle());

        driver.navigate().forward();
        StringUtility.verifyEquals(title2, driver.getTitle());
    }

    public static void edgeTest(){

        WebDriver driver = BrowserUtilities.getDriver("edge");

        driver.get("https://google.com");
        String title = driver.getTitle();

        driver.get("https://etsy.com");
        String title2 = driver.getTitle();

        driver.navigate().back();
        StringUtility.verifyEquals(title, driver.getTitle());

        driver.navigate().forward();
        StringUtility.verifyEquals(title2, driver.getTitle());
    }
}
