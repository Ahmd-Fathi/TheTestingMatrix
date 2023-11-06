package Search;

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

@Epic("Product Search Feature")
@Feature("User Product Search")
@Story("Searching and Browsing Products")

public class SearchTest extends TestBase {
    HomePage HomeObject;
    SearchPage SearchObject;
    String fakeUserName = Util.generateFakeFirstName();
    String fakeLastName = Util.generateFakeLastName();
    String fakeEmail = Util.generateFakeEmail();
    String fakePassword = Util.generateFakePassword();
    String firstProduct = "SAMSUNG";

    @Test(priority = 1)
    @Description("Verify that a user can register before searching for a product.")
    public void TC_UserCanRegisterBeforeSearchForProduct() throws IOException {
        HomeObject = new HomePage(driver);
        RegisterPage RegisterPage = HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage = RegisterPage.FillRegisterBox(fakeUserName, fakeLastName, fakeEmail, fakePassword);
        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));
    }

    @Test(priority = 2)
    @Description("Verify that a user can log in before searching for a product.")

    public void TC_UserCanLoginBeforeSearchForPordoacut() {
        HomeObject = new HomePage(driver);
        LoginPage LoginPage = HomeObject.clickLoginLink();
        LoginPage.setUserNameField(fakeEmail);
        LoginPage.setPasswordField(fakePassword);
        LoginPage.clickloginBtn();
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }

    @Test(priority = 3)
    @Description("Verify that a user can search for a product.")
    public void TC_UserCanSearchForProduct() throws InterruptedException, IOException {
        SearchObject = new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage = SearchObject.setSearchField(firstProduct);
        Util.screenshotAfterTest_Pass(driver, "SearchResult");
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Samsung Series 9 NP900X4C Premium Ultrabook"));

    }


}
