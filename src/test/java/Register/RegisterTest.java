package Register;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Pages.RegisterResultPage;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Util;

import java.io.IOException;

@Epic("User Registration Feature")
@Feature("User Account Registration")
@Story("User Account Registration Scenarios")

public class RegisterTest extends TestBase {
    HomePage HomeObject;
    String fakeUserName = Util.generateFakeFirstName();
    String fakeLastName = Util.generateFakeLastName();
    String fakeEmail = Util.generateFakeEmail();
    String fakePassword = Util.generateFakePassword();
    String WrongEmail = "Ahmed@";
    String ShortLengthUserNam = "mohamed@";
    String lengthPass = "12";

    @Test(priority = 1)
    @Description("Verify that a user cannot register with a password that is too short.")

    public void TC_VerifyThatAUserCannotRegisterWithAPasswordThatIsTooShort() {
        String ShortLengthUserNam = "A";
        HomeObject = new HomePage(driver);
        RegisterPage RegisterPage = HomeObject.ClickRegisterLink();
        RegisterPage.FillRegisterBox(fakeUserName, fakeLastName, fakeEmail, lengthPass);
        Assert.assertTrue(RegisterPage.ErrorMessageLengthPassword().contains("must have at least 6 characters"));
        driver.navigate().refresh();

    }

    @Test(priority = 2)
    @Description("Verify that a user cannot register with an invalid email address.")

    public void TC_VerifyThatAUserCannotRegisterWithInvalidEmail() {
        HomeObject = new HomePage(driver);
        RegisterPage RegisterPage = HomeObject.ClickRegisterLink();
        RegisterPage.FillRegisterBox(fakeUserName, fakeLastName, WrongEmail, fakePassword);
        Assert.assertTrue(RegisterPage.ErrorMessageWrongEmail().contains("Wrong email"));
        driver.navigate().refresh();
    }

    @Test(priority = 3)
    @Description("Verify that a user can successfully register with valid credentials.")
    public void TC_SuccessfulRegistrationwithValidCredentials() throws IOException {
        HomeObject = new HomePage(driver);
        RegisterPage RegisterPage = HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage = RegisterPage.FillRegisterBox(fakeUserName, fakeLastName, fakeEmail, fakePassword);

        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test(priority = 4)
    @Description("Verify that a user cannot log in with a username that is too short.")

    public void TC_VerifyThatAUserCannotLogInWithShortLengthUsername() {
        HomeObject = new HomePage(driver);
        LoginPage LoginPage = HomeObject.clickLoginLink();
        LoginPage.setUserNameField(ShortLengthUserNam);
        LoginPage.setPasswordField(fakePassword);
        LoginPage.clickloginBtn();
        Assert.assertTrue(LoginPage.loginWrongUsernamelength().contains("Wrong email"));

    }

    @Test(priority = 5)
    @Description("Verify that a user cannot log in with the wrong password.")
    public void TC_VerifyThatAUserCannotLogInWithWrongPass() {
        HomeObject = new HomePage(driver);
        LoginPage LoginPage = HomeObject.clickLoginLink();
        LoginPage.setUserNameField(fakeEmail);
        LoginPage.setPasswordField(lengthPass);
        LoginPage.clickloginBtn();
        Assert.assertTrue(LoginPage.ErrorWrongPass().contains("Login was unsuccessful. Please correct the errors and try again."));
    }

    @Test(priority = 6)
    @Description("Verify that a user can log in successfully with valid credentials.")

    public void TC_VerifyThatUserCanLoginSuccessfully() throws IOException {
        HomeObject = new HomePage(driver);
        LoginPage LoginPage = HomeObject.clickLoginLink();
        LoginPage.setUserNameField(fakeEmail);
        LoginPage.setPasswordField(fakePassword);
        LoginPage.clickloginBtn();
        Util.screenshotAfterTest_Pass(driver, "register with valid credential");
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }


}
