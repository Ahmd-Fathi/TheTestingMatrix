package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailFrindPage {
    WebDriver driver;

    public EmailFrindPage(WebDriver driver) {
        this.driver = driver;
    }

    //locator
    private By emailSuccessMessage = By.cssSelector("div[class=\"result\"]");
    //Method
    public String ActionSuccessMessageEmailSent() {
        return driver.findElement(emailSuccessMessage).getText();

    }

//locator
  private By friendEmailField = By.id("FriendEmail");

    private By messageFriendField = By.id("PersonalMessage");

    private By emailSendBtn = By.cssSelector("button[name=\"send-email\"]");
    //Method
    public void setFriendEmailField(String EmailFrind) {
        driver.findElement(friendEmailField).sendKeys(EmailFrind);
    }

    public void setMessageFriendField(String Messegtofrind) {
        driver.findElement(messageFriendField).sendKeys(Messegtofrind);
    }

    public void clickEmailSendBtn() {
        driver.findElement(emailSendBtn).click();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private By emailFriendPageSuccessMessage = By.cssSelector("div[class=\"page-title\"] h1");

    public String OnPageLoadSuccessMessage() {
        return driver.findElement(emailFriendPageSuccessMessage).getText();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private By InvalidFriendEmail = By.id("FriendEmail-error");

    public String GetTxtInvalidFriendEmail() {
        return driver.findElement(InvalidFriendEmail).getText();

    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
