package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;
    public  ShoppingCartPage(WebDriver driver)
    {
        this.driver=driver;
    }


private By shoppingCartSuccessLoadedMessage=By.cssSelector("div[class=\"page-title\"] h1");

public String getTxtshoppingCartSuccessLoadedMessage()
{
   return driver.findElement(shoppingCartSuccessLoadedMessage).getText();
}


private By AgreeToTermsAndConditions=By.id("termsofservice");

public void clickAgreeToTermsAndConditions()
{
    driver.findElement(AgreeToTermsAndConditions).click();
}


private By checkoutBtn=By.id("checkout");
public  billingPage clcikcheckoutBtn()
{
    driver.findElement(checkoutBtn).click();
    return new billingPage(driver);
}

































}
