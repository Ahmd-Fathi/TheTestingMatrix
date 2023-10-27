package EmailFrind;

import Pages.*;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Util;

public class EmailFrindTest extends TestBase {
    HomePage HomeObject;
    EmailFrindPage EmailFrindPage;
    String FirstName = "Ahmed";
    String LastName = "Fathi";
    String Email = "ahmedsdssHsessadsagazy@test.com";
    String password = "1234567";
    String produceName = "SAMSUNG";
    SearchPage SearchObject;
    ProductDetailsPage ProductDetailsObject;
    String EmailFrind = "mohameddwe@test.com";
    String Messegtofrind = "hello my friend ";
    String wrongFriendEmail = "ahmed@";


    @Test(priority = 1)
    public void TC_VerifyThatUserCanResiterBeforeEmailFriend() {
        HomeObject = new HomePage(driver);
        RegisterPage RegisterPage = HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage = RegisterPage.FillRegisterBox(FirstName, LastName, Email, password);
        Util.screenshotAfterTestPass(driver,"EmailfrindTest");
        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));


    }


    @Test(priority = 2)
    public void TC_VerifyThatUserCanLoginBeforeEmailFrind() {
        HomeObject = new HomePage(driver);
        LoginPage LoginPage = HomeObject.clickLoginLink();
        LoginPage.setUserNameField(Email);
        LoginPage.setPasswordField(password);
        LoginPage.clickloginBtn();
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }


    @Test(priority = 3)
    public void TC_UserCanSearchForProductBeforeEmailFriend() throws InterruptedException {
        SearchObject = new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage = SearchObject.setSearchField(produceName);
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Samsung Series 9 NP900X4C Premium Ultrabook"));

    }

    @Test(priority = 4)
    public void TC_InvalidFriendEmail() {

        ProductDetailsObject = new ProductDetailsPage(driver);
        EmailFrindPage EmailFrindPage = ProductDetailsObject.clickEmailFrindLink();
        EmailFrindPage.setFriendEmailField(wrongFriendEmail);
        EmailFrindPage.setMessageFriendField(Messegtofrind);
        EmailFrindPage.clickEmailSendBtn();

        Assert.assertTrue(EmailFrindPage.GetTxtInvalidFriendEmail().contains("Wrong email"));
        driver.navigate().refresh();
    }


    @Test(priority = 5)
    public void TC_UserCanEmailFriendSuccessfully() throws InterruptedException {


        EmailFrindPage=new EmailFrindPage(driver);
        EmailFrindPage.setFriendEmailField(EmailFrind);
        EmailFrindPage.setMessageFriendField(Messegtofrind);
        EmailFrindPage.clickEmailSendBtn();
        Assert.assertTrue(EmailFrindPage.ActionSuccessMessageEmailSent().contains("Your message has been sent"));








    }


}
