package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

private By CompuertLink=By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a");
    private By RegisterLink =By.linkText("Register");
private By notbookLink=By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a");
private By LoginLink=By.cssSelector("a[href=\"/login?returnUrl=%2F\"]");


    public  RegisterPage ClickRegisterLink()
    {
        driver.findElement(RegisterLink).click();
        return  new RegisterPage (driver);
    }

public  NotebookPage Hoverhoverinteract(){
    Actions action=new Actions(driver);
    action.moveToElement(driver.findElement(CompuertLink)).moveToElement(driver.findElement(notbookLink)).click().build().perform();

return new NotebookPage(driver);

}


public  LoginPage  clickLoginLink()
{
    driver.findElement(LoginLink).click();
    return new LoginPage(driver);
}
















































}
