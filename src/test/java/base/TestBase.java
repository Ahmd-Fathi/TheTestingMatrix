package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;
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
        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();

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




@AfterMethod
    public  void screenshotFailure(ITestResult result)

{
    if (ITestResult.FAILURE==result.getStatus());
    {
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
      try {
          Files.move(screenshot,new File("F:\\IdeaProjects\\AutomatedTestingFramework\\screenshot\\test.png"));
      }catch (IOException e) {
         e.printStackTrace();
      }
      }


    }


}














