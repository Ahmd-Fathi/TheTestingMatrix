package Wishlist;

import Pages.*;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Util;

import java.io.IOException;
@Epic("Wishlist")
@Feature("User should be able to add products to their wishlist.")
@Story("User should be able to add products to their wishlist before registering or logging in.")

public class WishlistTest extends TestBase {
    SearchPage SearchObject;
    ProductDetailsPage ProductDetailsPage;
    String produceName = "SAMSUNG";
    HomePage HomeObject;
    String fakeUserName = Util.generateFakeFirstName();
    String fakeLastName = Util.generateFakeLastName();
    String fakeEmail = Util.generateFakeEmail();
    String fakePassword = Util.generateFakePassword();


    @Test(priority = 1)
    @Description("Verify that a user can register for an account before adding products to their wishlist.")
    public void TC_UserCanRegisterBeforeAddingToWishlist() {
        HomeObject = new HomePage(driver);
        RegisterPage RegisterPage = HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage = RegisterPage.FillRegisterBox(fakeUserName, fakeLastName, fakeEmail, fakePassword);
        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));
    }

    @Test(priority = 2)
    @Description("Verify that the user can log in successfully before adding a product to their wishlist.")

    public void TC_UserCanLoginBeforeAddingToWishlist() {
        HomeObject = new HomePage(driver);
        LoginPage LoginPage = HomeObject.clickLoginLink();
        LoginPage.setUserNameField(fakeEmail);
        LoginPage.setPasswordField(fakePassword);
        LoginPage.clickloginBtn();
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }

    @Test(priority = 3)
    @Description("Verify that the user can search for a product before adding it to their wishlist.")
    public void TC_UserCanSearchForProductBeforeAddingToWishlist() throws InterruptedException {
        SearchObject = new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage = SearchObject.setSearchField(produceName);
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Samsung Series 9 NP900X4C Premium Ultrabook"));
    }

    @Test(priority = 4)
    @Description("Verify that a product can be successfully added to the user's wishlist.")
    public void TC_ProductSuccessfullyAddedToWishlistByUser() throws IOException {
        ProductDetailsPage = new ProductDetailsPage(driver);
        ProductDetailsPage.clickaddToWishlistLink();
        Assert.assertTrue(ProductDetailsPage.notificationBarWishlistAddSuccessMessage().contains("The product has been added to your "));
        WishlistPage WishlistPage = ProductDetailsPage.ClickWishlistNotificationBar();
        Util.screenshotAfterTest_Pass(driver, "wishlist test");
        Assert.assertTrue(WishlistPage.LoadWishlistPageSuccessMessage().contains("Wishlist"));
    }


}
