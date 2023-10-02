package Register;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Pages.RegisterResultPage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {
    HomePage HomeObject;
    String FirstName ="Ahmed";
    String LastName ="Fathi";
     String Email="Ahmesd2ssFathi@test.com";
     String password="1234567";
     String WrongEmail="Ahmed@";
     String ShortLengthUserNam="mohamed@";
     String  lengthPass="12";

     @Test (priority = 1)
     public  void TC_VerifyThatAUserCannotRegisterWithAPasswordThatIsTooShort()
     {
         HomeObject=new HomePage(driver);
         RegisterPage RegisterPage= HomeObject.ClickRegisterLink();
         RegisterPage.FillRegisterBox(FirstName,LastName,Email,lengthPass);
         Assert.assertTrue(RegisterPage.ErrorMessageLengthPassword().contains("must have at least 6 characters"));
         driver.navigate().refresh();

     }

    @Test (priority = 2)
    public  void TC_VerifyThatAUserCannotRegisterWithInvalidEmail()
    {
        HomeObject=new HomePage(driver);
        RegisterPage RegisterPage= HomeObject.ClickRegisterLink();
        RegisterPage.FillRegisterBox(FirstName,LastName,WrongEmail,lengthPass);
        Assert.assertTrue(RegisterPage.ErrorMessageWrongEmail().contains("Wrong email"));
        driver.navigate().refresh();
    }

    @Test (priority = 3)
    public void TC_SuccessfulRegistrationwithValidCredentials()
    {
        HomeObject=new HomePage(driver);
        RegisterPage RegisterPage =HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage= RegisterPage.FillRegisterBox(FirstName,LastName,Email,password);
        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test (priority = 4)
    public void TC_VerifyThatAUserCannotLogInWithShortLengthUsername()
    {
        HomeObject=new HomePage(driver);
        LoginPage LoginPage= HomeObject.clickLoginLink();
        LoginPage.setUserNameField(ShortLengthUserNam);
        LoginPage.setPasswordField(password);
        LoginPage.clickloginBtn();
        Assert.assertTrue(LoginPage.loginWrongUsernamelength().contains("Wrong email"));

    }

    @Test (priority = 5)
    public void TC_VerifyThatAUserCannotLogInWithShortLengthUsernameInLoginBox()
    {
        HomeObject=new HomePage(driver);
        LoginPage LoginPage= HomeObject.clickLoginLink();
        LoginPage.setUserNameField(ShortLengthUserNam);
        LoginPage.setPasswordField(password);
        LoginPage.clickloginBtn();
        Assert.assertTrue(LoginPage.loginWrongUsernamelength().contains("Wrong email"));
    }



    @Test (priority = 6)
    public void TC_VerifyThatAUserCannotLogInWithWrongPass()
    {
        HomeObject=new HomePage(driver);
        LoginPage LoginPage= HomeObject.clickLoginLink();
        LoginPage.setUserNameField(Email);
        LoginPage.setPasswordField(lengthPass);
        LoginPage.clickloginBtn();
        Assert.assertTrue(LoginPage.ErrorWrongPass().contains("Login was unsuccessful. Please correct the errors and try again."));

    }

    @Test (priority = 7)
    public void TC_VerifyThatUserCanLoginSuccessfully()
    {
        HomeObject=new HomePage(driver);
        LoginPage LoginPage= HomeObject.clickLoginLink();
        LoginPage.setUserNameField(Email);
        LoginPage.setPasswordField(password);
        LoginPage.clickloginBtn();
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }







































}
