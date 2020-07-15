package src.cbt_Tests.java.WebDriverPracticeWebsite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebDriverPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod(){

        driver.quit();
    }

    @Test
    public void firstTest(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");

        String actual = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']")).getText();
        String expected = "The date of birth is not valid";
        Assert.assertEquals(expected , actual);
    }

    @Test
    public void secondTest(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

        List<WebElement> button = driver.findElements(By.cssSelector(".form-check-label"));

        Assert.assertEquals(button.get(0).getText(),"C++");
        Assert.assertEquals(button.get(1).getText(),"Java");
        Assert.assertEquals(button.get(2).getText(),"JavaScript");
    }

    @Test
    public void thirdTest(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.name("firstname")).sendKeys("a");

        String actual = driver.findElement(By.xpath("//small[text()='first name must be " +
                                                    "more than 2 and less than 64 characters long']")).getText();
        String expected = "first name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void fourthTest(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.name("lastname")).sendKeys("a");

        String actual = driver.findElement(By.xpath("//small[text()='The last name must be " +
                                                        "more than 2 and less than 64 characters long']")).getText();
        String expected = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void fifthTest() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        driver.findElement(By.name("firstname")).sendKeys("Edison");
        driver.findElement(By.name("lastname")).sendKeys("Bajrami");
        driver.findElement(By.name("username")).sendKeys("EB2020");
        driver.findElement(By.name("email")).sendKeys("edison@cybertekschool.com");
        driver.findElement(By.name("password")).sendKeys("EdisonBajrami123");
        driver.findElement(By.name("phone")).sendKeys("010-456-6789");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("06/29/1993");

        WebElement dropdown = driver.findElement(By.name("department"));
        Select deptDropdown = new Select(dropdown);
        deptDropdown.selectByVisibleText("Tourism Office");

        WebElement jobTitle = driver.findElement(By.name("job_title"));
        Select title = new Select(jobTitle);
        title.selectByVisibleText("Product Owner");

        List<WebElement> button = driver.findElements(By.cssSelector(".form-check-label"));
        button.get(1).click();
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(5000);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.xpath("//div/p")).getText();
        Assert.assertEquals(actual, expected);
    }
}
