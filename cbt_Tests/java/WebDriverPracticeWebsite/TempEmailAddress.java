package src.cbt_Tests.java.WebDriverPracticeWebsite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TempEmailAddress {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tempmailaddress.com/");

        String emailAdd = driver.findElement(By.id("email")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();

        driver.findElement(By.name("full_name")).sendKeys("EdisonBajrami");
        driver.findElement(By.name("email")).sendKeys(emailAdd);
        driver.findElement(By.name("wooden_spoon")).click();

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals( driver.findElement(By.className("subheader")).getText(),expected);

        driver.navigate().to("https://www.tempmailaddress.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        String text = driver.findElement(By.cssSelector(".hidden-xs.hidden-sm.klikaciRadek.newMail")).getText();
        Assert.assertTrue(text.contains("do-not-reply@practice.cybertekschool.com"));

        driver.findElement(By.xpath("//div[@id='home']/div/table/tbody/tr[1]")).click();

        String expected1 = "do-not-reply@practice.cybertekschool.com";
        String expected2 = "Thanks for subscribing to practice.cybertekschool.com!";

        String actual1 = driver.findElement(By.id("odesilatel")).getText();
        String actual2 = driver.findElement(By.cssSelector("#predmet")).getText();

        Assert.assertEquals(actual1, expected1);
        Assert.assertEquals(actual2, expected2);
    }
}
