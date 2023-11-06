package EmailFrind;

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

@Epic("User Communication")
@Feature("Email a Friend")
@Story("Sending Emails to Friends")
public class EmailFrindTest extends TestBase {
    HomePage HomeObject;
    EmailFrindPage EmailFrindPage;
    String produceName = "SAMSUNG";
    String invalidemail = "ahmed";
    SearchPage SearchObject;
    ProductDetailsPage ProductDetailsObject;
    String Messegtofrind = "hello my friend ";
    String fakeUserName = Util.generateFakeFirstName();
    String fakeLastName = Util.generateFakeLastName();
    String fakeEmail = Util.generateFakeEmail();
    String fakePassword = Util.generateFakePassword();

    @Test(priority = 1)
    @Description("Verify that a user can register before using the 'Email a Friend' feature.")
    public void TC_VerifyThatUserCanResiterBeforeEmailFriend() throws IOException {
        HomeObject = new HomePage(driver);
        RegisterPage RegisterPage = HomeObject.ClickRegisterLink();
        RegisterResultPage RegisterResultPage = RegisterPage.FillRegisterBox(fakeUserName, fakeLastName, fakeEmail, fakePassword);
        Assert.assertTrue(RegisterResultPage.SuccessfulRegister().contains("Your registration completed"));
    }

    @Test(priority = 2)
    @Description("Verify that a user can log in before using the 'Email a Friend' feature.")

    public void TC_VerifyThatUserCanLoginBeforeEmailFrind() {
        HomeObject = new HomePage(driver);
        LoginPage LoginPage = HomeObject.clickLoginLink();
        LoginPage.setUserNameField(fakeEmail);
        LoginPage.setPasswordField(fakePassword);
        LoginPage.clickloginBtn();
        Assert.assertTrue(driver.findElement(LoginPage.SuccessfulLogin).isDisplayed());
    }

    @Test(priority = 3)
    @Description("Verify that a user can search for a product before using the 'Email a Friend' feature.")

    public void TC_UserCanSearchForProductBeforeEmailFriend() throws InterruptedException {
        SearchObject = new SearchPage(driver);
        ProductDetailsPage ProductDetailsPage = SearchObject.setSearchField(produceName);
        Assert.assertTrue(ProductDetailsPage.ResultProductAfterSearch().contains("Samsung Series 9 NP900X4C Premium Ultrabook"));
    }

    @Test(priority = 4)
    @Description("Verify handling of invalid friend email while using the 'Email a Friend' feature.")
    public void TC_InvalidFriendEmail() throws InterruptedException {
        ProductDetailsObject = new ProductDetailsPage(driver);
        EmailFrindPage EmailFrindPage = ProductDetailsObject.clickEmailFrindLink();
        EmailFrindPage.setFriendEmailField(invalidemail);
        Thread.sleep(3000);
        EmailFrindPage.setMessageFriendField(Messegtofrind);
        EmailFrindPage.clickEmailSendBtn();
        Assert.assertTrue(EmailFrindPage.GetTxtInvalidFriendEmail().contains("Wrong email"));
        driver.navigate().refresh();
    }

    @Test(priority = 5)
    @Description("Verify that a user can successfully send an email to a friend using the 'Email a Friend' feature.")
    public void TC_UserCanEmailFriendSuccessfully() throws InterruptedException, IOException {

        EmailFrindPage = new EmailFrindPage(driver);
        EmailFrindPage.setFriendEmailField(fakeEmail);
        EmailFrindPage.setMessageFriendField(Messegtofrind);
        EmailFrindPage.clickEmailSendBtn();
        Util.screenshotAfterTest_Pass(driver, "EmailfrindTest");
        Assert.assertTrue(EmailFrindPage.ActionSuccessMessageEmailSent().contains("Your message has been sent"));


    }


}
