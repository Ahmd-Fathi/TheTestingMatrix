package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver)
    {
        this.driver=driver;
    }

private By SuccessMessageOnceINavigateToRegisterPage= By.cssSelector("div[class=\"page-title\"]");

private By FirstNameField=By.id("FirstName");
private By LastNameField=By.id("LastName");
private By DayBirth=By.cssSelector("select[name=\"DateOfBirthDay\"]");
private By MonthBirth=By.cssSelector("select[name=\"DateOfBirthMonth\"]");
private By YearBirth=By.cssSelector("select[name=\"DateOfBirthYear\"]");
private  By EmailField=By.id("Email");

private By NewsletterMarkDisable=By.id("Newsletter");
private By passwordField=By.id("Password");
private By confirmpasswordField=By.id("ConfirmPassword");
private By registerBtn=By.id("register-button");
private By ErrorMessagePassword=By.cssSelector("span[id=\"Password-error\"] li");
private By ErrorMessageEmail=By.id("Email-error");


public  String ErrorMessageWrongEmail()
{
    return driver.findElement(ErrorMessageEmail).getText();
}











    public  String SuccessMessageOnce()
    {
        return driver.findElement(SuccessMessageOnceINavigateToRegisterPage).getText();
    }
    public  String ErrorMessageLengthPassword()
    {
        return driver.findElement(ErrorMessagePassword).getText();
    }

public RegisterResultPage FillRegisterBox(String FirstName ,String LastName,String Email,String password)
{
    driver.findElement(FirstNameField).sendKeys(FirstName);
    driver.findElement(LastNameField).sendKeys(LastName);

    Select select=new Select(driver.findElement(DayBirth));
    select.selectByIndex(2);

    Select select1=new Select(driver.findElement(MonthBirth));
    select1.selectByIndex(4);

    Select select2 =new Select(driver.findElement(YearBirth));
    select2.selectByIndex(5);


    driver.findElement(EmailField).sendKeys(Email);


    driver.findElement(NewsletterMarkDisable).click();

    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(confirmpasswordField).sendKeys(password);
    driver.findElement(registerBtn).click();

    return new RegisterResultPage (driver);

}
















































}
