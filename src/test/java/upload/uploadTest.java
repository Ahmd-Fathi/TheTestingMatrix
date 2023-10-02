package upload;

import Pages.fileUploadPage;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class uploadTest extends TestBase {

    fileUploadPage fileUploadPage;
    @Test
    public  void TC_FileUUpload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        fileUploadPage=new fileUploadPage(driver);
        fileUploadPage.choosefileanduploadit("F:\\IdeaProjects\\AutomatedTestingFramework\\src\\test\\java\\upload\\uploadTest.java");
        fileUploadPage.clicksubmituploadbutton();
        Assert.assertTrue(fileUploadPage.getTxtsuccessmessageafterupload().contains("File Uploaded!"));


    }














}
