package Wishlist;

import Pages.*;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends TestBase {
    SearchPage SearchObject;
    ProductDetailsPage ProductDetailsPage;
    String produceName="SAMSUNG";
    HomePage HomeObject;
    String FirstName ="Ahmed";
    String LastName ="Fathi";
    String Email="Ahmesd2ssdFathi@test.com";
    String password="1234567";


    @Test(priority = 1)
    public void TC_UserCanRegisterBeforeAddingToWishlist()
    {
        HomeObject=new HomePage(driver);
        RegisterPage RegisterPage =HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage= RegisterPage.FillRegisterBox(FirstName,LastName,Email,password);
        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));
    }

    @Test (priority = 2)
    public void TC_UserCanLoginBeforeAddingToWishlist()
    {
        HomeObject=new HomePage(driver);
        LoginPage LoginPage= HomeObject.clickLoginLink();
        LoginPage.setUserNameField(Email);
        LoginPage.setPasswordField(password);
        LoginPage.clickloginBtn();
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }

    @Test(priority = 3)
    public  void TC_UserCanSearchForProductBeforeAddingToWishlist() throws InterruptedException {
        SearchObject=new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage=  SearchObject.setSearchField(produceName);
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Samsung Series 9 NP900X4C Premium Ultrabook"));

    }


    @Test (priority =4)
    public  void TC_ProductSuccessfullyAddedToWishlistByUser()
    {
        ProductDetailsPage=new ProductDetailsPage(driver);
        ProductDetailsPage.clickaddToWishlistLink();
        Assert.assertTrue(ProductDetailsPage.notificationBarWishlistAddSuccessMessage().contains("The product has been added to your "));
        WishlistPage  WishlistPage=  ProductDetailsPage.ClickWishlistNotificationBar();
       Assert.assertTrue(WishlistPage.LoadWishlistPageSuccessMessage().contains("Wishlist"));
    }

























































}
