package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {

    WebDriver driver;
    public WishlistPage(WebDriver driver)
    {
        this.driver=driver;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private By WishlistPageSuccessMessage= By.cssSelector("div[class=\"page-title\"] h1");

    public String LoadWishlistPageSuccessMessage()
    {
return driver.findElement(WishlistPageSuccessMessage).getText();

    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////




























}
