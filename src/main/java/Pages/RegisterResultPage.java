package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterResultPage {
    WebDriver driver;
    public  RegisterResultPage(WebDriver driver)
    {
        this.driver=driver;
    }


    private By RegisterResult=By.cssSelector("div[class=\"result\"]");




    
public  String SuccessfulRegister()
{
   return driver.findElement(RegisterResult).getText();

}





















































}