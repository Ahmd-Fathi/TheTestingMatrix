package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class shippingMethodPage {
    WebDriver driver;
    public shippingMethodPage(WebDriver driver)
    {
        this.driver=driver;
    }



private By ShippingMethodPageLoadedSuccessMessage=By.cssSelector("div[class=\"page-title\"] h1");

    public  String getTxtShippingMethodPageLoadedSuccessMessage ()
    {
        return driver.findElement(ShippingMethodPageLoadedSuccessMessage).getText();
    }



private By ContinueToShippingMethodBtn=By.cssSelector("button[onclick=\"ShippingMethod.save()\"]");




public  PaymentMethodPage clickContinueToShippingMethodBtn()
{
    driver.findElement(ContinueToShippingMethodBtn).click();
    return new PaymentMethodPage(driver);
}

public   By PaymentMethodPageLoadedSuccessMessage=By.linkText("Pay by cheque or money order");








































}
