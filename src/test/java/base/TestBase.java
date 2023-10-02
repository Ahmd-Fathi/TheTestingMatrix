package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utility.helper;

import java.util.concurrent.TimeUnit;

public class TestBase {

   protected static WebDriver driver;



    @BeforeClass
    public  void StartDriver()
    {


        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");


    }



@AfterClass
    public  void QuitDriver() throws InterruptedException {
    Thread.sleep(2000);
    driver.quit();
}






    @AfterMethod
    public void screenShootOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Fail");
            System.out.println("Taking screenshot");
            helper.captureScreenshots(driver, result.getName());
        }

    }
























}
