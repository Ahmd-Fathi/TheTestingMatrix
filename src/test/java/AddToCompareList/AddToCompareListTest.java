package AddToCompareList;

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

@Epic("Product Comparison")
@Feature("Add to Compare List")
@Story("Comparing Products")
public class AddToCompareListTest extends TestBase {
    HomePage HomeObject;
    SearchPage SearchObject;
    AddToCompareListPage AddToCompareListPage;
    ProductDetailsPage ProductDetailsPage;
    String firstProduct = "SAMSUNG";
    String secondProduct = "MacBook";

    String fakeUserName = Util.generateFakeFirstName();
    String fakeLastName = Util.generateFakeLastName();
    String fakeEmail = Util.generateFakeEmail();
    String fakePassword = Util.generateFakePassword();

    @Test(priority = 1)
    @Description("Verify that a user can register before adding products to the compare list.")
    public void TC_UserCanRegisterBeforeAddingToCompareList() throws IOException {
        HomeObject = new HomePage(driver);
        RegisterPage RegisterPage = HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage = RegisterPage.FillRegisterBox(fakeUserName, fakeLastName, fakeEmail, fakePassword);
        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));

    }

    @Test(priority = 2)
    @Description("Verify that a user can log in before adding products to the compare list.")

    public void TC_UserCanLoginBeforeAddingToCompareList() {
        HomeObject = new HomePage(driver);
        LoginPage LoginPage = HomeObject.clickLoginLink();
        LoginPage.setUserNameField(fakeEmail);
        LoginPage.setPasswordField(fakePassword);
        LoginPage.clickloginBtn();
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }

    @Test(priority = 3)
    @Description("Verify that a user can search for a product before adding it to the compare list.")

    public void TC_UserCanSearchForProductOneBeforeAddingToCompareList() throws InterruptedException {
        SearchObject = new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage = SearchObject.setSearchField(firstProduct);
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Samsung Series 9 NP900X4C Premium Ultrabook"));
        ProductDetailsPage.clcikAddToCompareListLink();
        Assert.assertTrue(ProductDetailsPage.notificationBarWishlistAddSuccessMessage().contains("The product has been added to your "));

    }

    @Test(priority = 4)
    @Description("Verify that a user can search for a second product before adding it to the compare list.")

    public void TC_UserCanSearchForProductTwoBeforeAddingToCompareList() throws InterruptedException {
        SearchObject = new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage = SearchObject.setSearchField(secondProduct);
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Apple MacBook Pro 13-inch"));
        ProductDetailsPage.clcikAddToCompareListLink();
        Assert.assertTrue(ProductDetailsPage.notificationBarWishlistAddSuccessMessage().contains("The product has been added to your "));
    }

    @Test(priority = 5)
    @Description("Verify that a user can navigate to the compare product page after adding two products.")

    public void TC_UserCanNavigateToCompareProductPageAfterAddingTwoProducts() throws IOException {
        ProductDetailsPage = new ProductDetailsPage(driver);
        AddToCompareListPage AddToCompareListPage = ProductDetailsPage.clcikCompareListNotificationBar();
        Assert.assertTrue(AddToCompareListPage.CompareProductPageLoadSuccessMessageDisplayed().contains("Compare products"));
        Util.screenshotAfterTest_Pass(driver, "add to compare test");

    }

    @Test(priority = 6)
    @Description("Verify interaction with a table to print all information and count rows.")
    public void TC_InteractWithTableToPrintAllInformationAndCountRowsTest() throws InterruptedException {
        AddToCompareListPage = new AddToCompareListPage(driver);
        AddToCompareListPage.InteractWithAllTable();
        // Thread.sleep(2000);

    }


}
