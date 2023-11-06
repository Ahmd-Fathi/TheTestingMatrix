package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class fileUploadPage {


    WebDriver driver;

    public fileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    private By successmessageafterupload = By.cssSelector("div[class=\"example\"] h3");
    private By submituploadbutton = By.id("file-submit");

    private By chooseFileButton = By.id("file-upload");

    public void choosefileanduploadit(String path) {
        driver.findElement(chooseFileButton).sendKeys(path);


    }

    public void clicksubmituploadbutton() {
        driver.findElement(submituploadbutton).click();
    }


    public String getTxtsuccessmessageafterupload() {

        return driver.findElement(successmessageafterupload).getText();
    }


}
