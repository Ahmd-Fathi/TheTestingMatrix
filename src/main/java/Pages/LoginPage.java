package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By UserNameField = By.id("Email");
    private By PasswordField = By.id("Password");
    private By loginBtn = By.cssSelector("button[class=\"button-1 login-button\"]");

    private By WrongUsername = By.id("Email-error");
    public By SuccessfulLogin = By.cssSelector("a[class=\"ico-account\"]");
    private By MessageWrongPass = By.cssSelector("div[class=\"message-error validation-summary-errors\"]");

    public String loginWrongUsernamelength() {
        return driver.findElement(WrongUsername).getText();
    }

    public String ErrorWrongPass() {
        return driver.findElement(MessageWrongPass).getText();
    }

    public void setUserNameField(String username) {
        driver.findElement(UserNameField).sendKeys(username);
    }

    public void setPasswordField(String pass) {
        driver.findElement(PasswordField).sendKeys(pass);
    }


    public void clickloginBtn() {
        driver.findElement(loginBtn).click();
    }


}
