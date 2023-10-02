package shoppingCart;

import Pages.*;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class shoppingCartTest extends TestBase {
    ProductDetailsPage ProductDetailsPage;
    HomePage HomeObject;
    ShoppingCartPage ShoppingCartPage;
    PaymentMethodPage PaymentMethodPage;
    shippingMethodPage shippingMethodPage;
    completecheckoutpage completecheckoutpage;
    SearchPage SearchObject;
    String FirstName ="Ahmed";
    String LastName ="Fathi";
    String Email="Ahmeswsazxaasssssd@test.com";
    String password="1234567";
    String WrongEmail="Ahmed@";
    String ShortLengthUserNam="mohamed@";
    String  lengthPass="12";
    String firstProduct="SAMSUNG";
    String secondProduct= "MacBook";
    String PhoneNumber="23232322";
    String ZipCode= "023";
    String City="cairo";
    String  Address  ="22 abd elfatah azzam st";


    @Test(priority = 1)
    public  void TC_userCanRegisterBeforeAddToCartt()
    {
        HomeObject=new HomePage(driver);
        RegisterPage RegisterPage =HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage= RegisterPage.FillRegisterBox(FirstName,LastName,Email,password);
        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));


    }

    @Test(priority = 2)
    public  void TC_userCanLoginBeforeAddToCart()
    {
        HomeObject=new HomePage(driver);
        LoginPage LoginPage= HomeObject.clickLoginLink();
        LoginPage.setUserNameField(Email);
        LoginPage.setPasswordField(password);
        LoginPage.clickloginBtn();
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }


    @Test(priority = 3)
    public  void TC_selectProductToAddToShoppingCart() throws InterruptedException {
        SearchObject=new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage=  SearchObject.setSearchField(firstProduct);
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Samsung Series 9 NP900X4C Premium Ultrabook"));

    }

    @Test(priority = 4)
    public  void TC_UserWillAddSelectedProductToCart() throws InterruptedException {

        ProductDetailsPage=new ProductDetailsPage(driver);
        ProductDetailsPage.clickAddToCartLink();
        Assert.assertTrue(ProductDetailsPage.notificationBarWishlistAddSuccessMessage().contains("The product has been added to your "));
        ShoppingCartPage  ShoppingCartPage=ProductDetailsPage.clickaddToShoppingCartHyperlink();
        Assert.assertTrue( ShoppingCartPage.getTxtshoppingCartSuccessLoadedMessage().contains("Shopping cart"));

    }


@Test (priority = 5)
    public void TC_userFillBillingData() throws InterruptedException {
    ShoppingCartPage=new ShoppingCartPage(driver);
    ShoppingCartPage.clickAgreeToTermsAndConditions();
    billingPage  billingPage=  ShoppingCartPage.clcikcheckoutBtn();
    billingPage.setCityField(City);
    billingPage.dropSelectCountry();
    billingPage.setZipCodeField(ZipCode);
    billingPage.setAddressField(Address);
    billingPage.setPhoneNumberField(PhoneNumber);
    shippingMethodPage shippingMethodPage=billingPage.clickcontinueButton();
    Assert.assertTrue(shippingMethodPage.getTxtShippingMethodPageLoadedSuccessMessage().contains("Checkout"));
    Thread.sleep(3000);
}

@Test(priority = 6)
    public  void TC_UserWillChoosePaymentMethod() throws InterruptedException {
    shippingMethodPage=new shippingMethodPage(driver);
    PaymentMethodPage  PaymentMethodPage=shippingMethodPage.clickContinueToShippingMethodBtn();
    PaymentInfoPage  PaymentInfoPage=PaymentMethodPage.clickContinueOnPaymentMethod();
    confirmOrderPage  confirmOrderPage=PaymentInfoPage.clickContinuePaymentInfo();
    completecheckoutpage  completecheckoutpage=confirmOrderPage.clickconfirmorderbutton();
    Assert.assertTrue( completecheckoutpage.getTxtsuccessmessagecompletcheckoutpageloaded().contains("Your order has been successfully processed"));

}


























































































}
