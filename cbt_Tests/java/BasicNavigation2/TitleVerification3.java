package src.cbt_Tests.java.BasicNavigation2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) throws InterruptedException {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com", "https://www.westelm.com", "https://walmart.com");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(urls.get(0));
        String luluTitle = driver.getTitle().toLowerCase().replace(" ", "").trim();
        String luluUrl = driver.getCurrentUrl();

        if(luluUrl.contains(luluTitle)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }

        driver.close();
        Thread.sleep(2000);

        driver = new ChromeDriver();
        driver.get(urls.get(1));
        String wayfairTitle = driver.getTitle().toLowerCase().replace(" ", "").trim();
        String wayfairUrl = driver.getCurrentUrl();

        if(wayfairUrl.contains(wayfairTitle)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }

        driver.close();
        Thread.sleep(2000);

        driver = new ChromeDriver();
        driver.get(urls.get(2));
        String westelmTitle = driver.getTitle().toLowerCase().replace(" ", "").trim();
        String westelmUrl = driver.getCurrentUrl();

        if(westelmUrl.contains(westelmTitle)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }

        driver.close();
        Thread.sleep(2000);

        driver = new ChromeDriver();
        driver.get(urls.get(3));
        String walmartTitle = driver.getTitle().toLowerCase().replace(" ", "").trim();
        String walmartUrl = driver.getCurrentUrl();

        if(walmartUrl.contains(walmartTitle)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }

        driver.quit();
    }
}
