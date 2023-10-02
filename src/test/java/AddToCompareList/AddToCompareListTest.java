package AddToCompareList;

import Pages.*;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCompareListTest extends TestBase {
    HomePage HomeObject;
    SearchPage SearchObject;
    AddToCompareListPage AddToCompareListPage;
    ProductDetailsPage ProductDetailsPage;
    String FirstName ="Ahmed";
    String LastName ="Fathi";
    String Email="Ahmesdasssssss2accssFathi@test.com";
    String password="1234567";
    String firstProduct="SAMSUNG";
    String secondProduct= "MacBook";



    @Test(priority = 1)
    public  void TC_UserCanRegisterBeforeAddingToCompareList()
    {
        HomeObject=new HomePage(driver);
        RegisterPage RegisterPage =HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage= RegisterPage.FillRegisterBox(FirstName,LastName,Email,password);
        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));


    }


    @Test(priority = 2)
    public  void TC_UserCanLoginBeforeAddingToCompareList()
    {
        HomeObject=new HomePage(driver);
        LoginPage LoginPage= HomeObject.clickLoginLink();
        LoginPage.setUserNameField(Email);
        LoginPage.setPasswordField(password);
        LoginPage.clickloginBtn();
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }


    @Test(priority = 3)
    public  void TC_UserCanSearchForProductOneBeforeAddingToCompareList() throws InterruptedException {
        SearchObject=new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage=  SearchObject.setSearchField(firstProduct);
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Samsung Series 9 NP900X4C Premium Ultrabook"));
        ProductDetailsPage.clcikAddToCompareListLink();
        Assert.assertTrue(ProductDetailsPage.notificationBarWishlistAddSuccessMessage().contains("The product has been added to your "));

    }



    @Test(priority = 4)
    public  void TC_UserCanSearchForProductTwoBeforeAddingToCompareList() throws InterruptedException {
        SearchObject=new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage=  SearchObject.setSearchField(secondProduct);
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Apple MacBook Pro 13-inch"));
        ProductDetailsPage.clcikAddToCompareListLink();
        Assert.assertTrue(ProductDetailsPage.notificationBarWishlistAddSuccessMessage().contains("The product has been added to your "));

    }




@Test(priority = 5)
    public  void TC_UserCanNavigateToCompareProductPageAfterAddingTwoProducts()
{
    ProductDetailsPage=new ProductDetailsPage(driver);
    AddToCompareListPage  AddToCompareListPage=ProductDetailsPage.clcikCompareListNotificationBar();
Assert.assertTrue(AddToCompareListPage.CompareProductPageLoadSuccessMessageDisplayed().contains("Compare products"));

}


@Test (priority = 6)
    public void TC_InteractWithTableToPrintAllInformationAndCountRowsTest() throws InterruptedException {
    AddToCompareListPage=new AddToCompareListPage(driver);
    AddToCompareListPage.InteractWithAllTable();
   // Thread.sleep(2000);



}































































}
