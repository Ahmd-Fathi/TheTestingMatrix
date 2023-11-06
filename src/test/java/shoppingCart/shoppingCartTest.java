package shoppingCart;

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

@Epic("Shopping Cart Feature")
@Feature("User Shopping Cart")
@Story("Adding and Managing Items in the Shopping Cart")

public class shoppingCartTest extends TestBase {
    ProductDetailsPage ProductDetailsPage;
    HomePage HomeObject;
    ShoppingCartPage ShoppingCartPage;
    PaymentMethodPage PaymentMethodPage;
    shippingMethodPage shippingMethodPage;
    completecheckoutpage completecheckoutpage;
    SearchPage SearchObject;
    String fakeUserName = Util.generateFakeFirstName();
    String fakeLastName = Util.generateFakeLastName();
    String fakeEmail = Util.generateFakeEmail();
    String fakePassword = Util.generateFakePassword();
    String fakeAddress = Util.generateFakeAddress();
    String fakeNumber = Util.generateFakePhoneNumber();
    String firstProduct = "SAMSUNG";
    String City = "cairo";

    @Test(priority = 1)
    @Description("Verify that a user can successfully register before adding items to the shopping cart.")

    public void TC_userCanRegisterBeforeAddToCartt() {
        HomeObject = new HomePage(driver);
        RegisterPage RegisterPage = HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage = RegisterPage.FillRegisterBox(fakeUserName, fakeLastName, fakeEmail, fakePassword);
        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));

    }

    @Test(priority = 2)
    @Description("Verify that a user can successfully log in before adding items to the shopping cart.")

    public void TC_userCanLoginBeforeAddToCart() {
        HomeObject = new HomePage(driver);
        LoginPage LoginPage = HomeObject.clickLoginLink();
        LoginPage.setUserNameField(fakeEmail);
        LoginPage.setPasswordField(fakePassword);
        LoginPage.clickloginBtn();
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }


    @Test(priority = 3)
    @Description("Verify that a user can select a product to add to the shopping cart.")

    public void TC_selectProductToAddToShoppingCart() throws InterruptedException {
        SearchObject = new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage = SearchObject.setSearchField(firstProduct);
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Samsung Series 9 NP900X4C Premium Ultrabook"));

    }

    @Test(priority = 4)
    @Description("Verify that the user can successfully add the selected product to the shopping cart.")

    public void TC_UserWillAddSelectedProductToCart() throws InterruptedException {

        ProductDetailsPage = new ProductDetailsPage(driver);
        ProductDetailsPage.clickAddToCartLink();
        Assert.assertTrue(ProductDetailsPage.notificationBarWishlistAddSuccessMessage().contains("The product has been added to your "));
        ShoppingCartPage ShoppingCartPage = ProductDetailsPage.clickaddToShoppingCartHyperlink();
        Assert.assertTrue(ShoppingCartPage.getTxtshoppingCartSuccessLoadedMessage().contains("Shopping cart"));

    }


    @Test(priority = 5)
    @Description("Verify that the user can successfully fill in billing data.")

    public void TC_userFillBillingData() throws InterruptedException {
        ShoppingCartPage = new ShoppingCartPage(driver);
        ShoppingCartPage.clickAgreeToTermsAndConditions();
        billingPage billingPage = ShoppingCartPage.clcikcheckoutBtn();
        billingPage.setCityField(City);
        billingPage.dropSelectCountry();
        billingPage.setZipCodeField(fakePassword);
        billingPage.setAddressField(fakeAddress);
        billingPage.setPhoneNumberField(fakeNumber);
        shippingMethodPage shippingMethodPage = billingPage.clickcontinueButton();
        Assert.assertTrue(shippingMethodPage.getTxtShippingMethodPageLoadedSuccessMessage().contains("Checkout"));

    }

    @Test(priority = 6)
    @Description("Verify that the user can choose a payment method during the checkout process.")

    public void TC_UserWillChoosePaymentMethod() throws InterruptedException, IOException {
        shippingMethodPage = new shippingMethodPage(driver);
        PaymentMethodPage PaymentMethodPage = shippingMethodPage.clickContinueToShippingMethodBtn();
        PaymentInfoPage PaymentInfoPage = PaymentMethodPage.clickContinueOnPaymentMethod();
        confirmOrderPage confirmOrderPage = PaymentInfoPage.clickContinuePaymentInfo();
        completecheckoutpage completecheckoutpage = confirmOrderPage.clickconfirmorderbutton();
        Util.screenshotAfterTest_Pass(driver, "shopping cart test");

        Assert.assertTrue(completecheckoutpage.getTxtsuccessmessagecompletcheckoutpageloaded().contains("Your order has been successfully processed"));

    }


}
