package src.cbt_Tests.java.BasicNavigation2;
import java.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import src.cbt_Utilities.java.*;

public class TitleVerificationTests {
    public static void main(String[] args) throws InterruptedException {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                                          "http://practice.cybertekschool.com/dropdown",
                                          "http://practice.cybertekschool.com/login");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //TITLEs
        driver.get(urls.get(0));
        String expectedTitle = driver.getTitle();

        driver.get(urls.get(1));
        String dropdownTitle = driver.getTitle();

        StringUtility.verifyEquals(expectedTitle, dropdownTitle);
        Thread.sleep(2000);
        driver.get(urls.get(2));
        String loginTitle = driver.getTitle();

        StringUtility.verifyEquals(expectedTitle, loginTitle);

        //URLs
        String expectedUrl = "http://practice.cybertekschool.com/";

        for(String url: urls){
            driver.get(url);

            String actualUrl = driver.getCurrentUrl();

            if(actualUrl.startsWith(expectedUrl)){
                System.out.println("PASS");
            }
            else{
                System.out.println("FAIL");
            }
        }
    }

}
