package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.helper;

import java.util.concurrent.TimeUnit;

public class TestBase {

   protected static WebDriver driver;



    @BeforeClass
    @Parameters({"browser"})
    public  void StartDriver(@Optional ("Chrome") String browserName)
    {

        if (browserName.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("Firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");


    }



@AfterClass
    public  void QuitDriver() throws InterruptedException {
    Thread.sleep(2000);
    driver.quit();
}































}
