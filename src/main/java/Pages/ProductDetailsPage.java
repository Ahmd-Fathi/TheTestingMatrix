package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    WebDriver driver;
    public ProductDetailsPage(WebDriver driver)
    {
        this.driver=driver;
    }

private By ResultProduct =By.cssSelector("div[class=\"product-name\"] h1");

private By EmailFrindLink=By.cssSelector("button[class=\"button-2 email-a-friend-button\"]");


public  EmailFrindPage clickEmailFrindLink()
{
    driver.findElement(EmailFrindLink).click();
    return  new EmailFrindPage(driver);
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////// add to wishList////////////////////////
private By addToWishlistLink=By.id("add-to-wishlist-button-6");

public  void  clickaddToWishlistLink()
{
    driver.findElement(addToWishlistLink).click();
}
private By WishlistAddSuccessMessage=By.cssSelector("div[class=\"bar-notification success\"] p");

public  String notificationBarWishlistAddSuccessMessage()
{
    return driver.findElement(WishlistAddSuccessMessage).getText();
}

private By WishlistOpenedFromNotificationBar=By.cssSelector("p[class=\"content\"] a[href=\"/wishlist\"]");

public WishlistPage ClickWishlistNotificationBar()
{
    driver.findElement(WishlistOpenedFromNotificationBar).click();
    return new WishlistPage (driver);
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////add to compairelist//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private  By AddToCompareListLink=By.cssSelector("div[class=\"compare-products\"]");

public  void clcikAddToCompareListLink()
{
    driver.findElement(AddToCompareListLink).click();
}


private  By CompareListAddSuccessMessageDisplayed=By.cssSelector("p[class=\"content\"]");

public  String getTxtCompareListAddSuccessMessageDisplayed()
{
    return driver.findElement(CompareListAddSuccessMessageDisplayed).getText();
}


private  By CompareListNotificationBar=By.cssSelector("p[class=\"content\"] a[href=\"/compareproducts\"]");

public AddToCompareListPage clcikCompareListNotificationBar()
{
    driver.findElement(CompareListNotificationBar).click();
    return new AddToCompareListPage(driver);
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private  By addToCartLink=By.id("add-to-cart-button-6");

public void clickAddToCartLink()
{
    driver.findElement(addToCartLink).click();
}

private By addToCartNotificationSuccessMessage =By.cssSelector("div[class=\"bar-notification success\"] p[class=\"content\"]");

public String getTxtaddToCartNotificationSuccessMessage()
{
    return driver.findElement(addToCartNotificationSuccessMessage).getText();


}
private  By addToShoppingCartHyperlink=By.cssSelector("p[class=\"content\"] a[href=\"/cart\"]");

public  ShoppingCartPage  clickaddToShoppingCartHyperlink()
{

    driver.findElement(addToShoppingCartHyperlink).click();
    return new  ShoppingCartPage(driver);
}













































    public String ResultProductAfterSearch()
{
   return driver.findElement(ResultProduct).getText();
}




























































}
