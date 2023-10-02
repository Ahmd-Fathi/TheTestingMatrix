package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class confirmOrderPage {


    WebDriver driver;
    public  confirmOrderPage(WebDriver driver)
    {this.driver=driver;}



private By confirmorderbutton= By.cssSelector("button[class=\"button-1 confirm-order-next-step-button\"]");




public completecheckoutpage clickconfirmorderbutton()
{
    driver.findElement(confirmorderbutton).click();
    return new completecheckoutpage(driver);
}











































































}
