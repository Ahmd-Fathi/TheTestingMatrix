package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    public static String DownloadPath = "F:\\IdeaProjects\\AutomatedTestingFramework\\download";

    public static FirefoxOptions FireFoxOption() {
        FirefoxOptions options = new FirefoxOptions();

        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.download.dir", DownloadPath);
        // options.addPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
        options.addPreference("browser.download.manager.showWhenStarting", false);
        return options;
    }


    public static ChromeOptions ChromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> ChromePrefs = new HashMap<String, Object>();
        ChromePrefs.put("profile.default.content_settings.popups", 0);
        ChromePrefs.put("download.default_directory", DownloadPath);
        options.setExperimentalOption("prefs", ChromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return options;
    }


    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("Chrome") String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(ChromeOption());

        } else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(FireFoxOption());

        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }


    @AfterClass
    public void quiatedriver() throws InterruptedException {

        driver.quit();
    }


    @AfterMethod
    public void takscrrenshootonfalier(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File SCREENSHOOTFOLDER = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(SCREENSHOOTFOLDER, new File("F:\\IdeaProjects\\AutomationUniversity\\SCREENSHOOTFOLDER\\test.png"));
                Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}















