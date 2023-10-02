package Search;

import Pages.*;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
    HomePage HomeObject;
    SearchPage SearchObject;
    String FirstName ="Ahmed";
    String LastName ="Fathi";
    String Email="Ahmesdsssss2ssFathi@test.com";
    String password="1234567";
    String WrongEmail="Ahmed@";
    String ShortLengthUserNam="mohamed@";
    String  lengthPass="12";
    String firstProduct="SAMSUNG";
    String secondProduct= "MacBook";
    @Test(priority = 1)
    public  void TC_UserCanRegisterBeforeSearchForProduct()
    {
        HomeObject=new HomePage(driver);
        RegisterPage RegisterPage =HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage= RegisterPage.FillRegisterBox(FirstName,LastName,Email,password);
        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));


    }



    @Test(priority = 2)
    public  void TC_UserCanLoginBeforeSearchForPordoacut()
    {
        HomeObject=new HomePage(driver);
        LoginPage LoginPage= HomeObject.clickLoginLink();
        LoginPage.setUserNameField(Email);
        LoginPage.setPasswordField(password);
        LoginPage.clickloginBtn();
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }



    @Test(priority = 3)
    public  void TC_UserCanSearchForProduct() throws InterruptedException {
        SearchObject=new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage=  SearchObject.setSearchField(firstProduct);
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Samsung Series 9 NP900X4C Premium Ultrabook"));

    }

















































}
