package Hover;

import Pages.HomePage;
import Pages.NotebookPage;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Util;

import java.io.IOException;

@Epic("User Interaction")
@Feature("Mouse Hover Action")
@Story("Hovering Over Elements")
public class HoverTest extends TestBase {
    HomePage HomeObject;

    @Test
    @Description("Verify mouse hover interaction with elements.")
    public void TC_HoverInteraction() throws IOException {
        HomeObject = new HomePage(driver);
        NotebookPage NotebookPage = HomeObject.Hoverhoverinteract();
        Util.screenshotAfterTest_Pass(driver, "hover test");
        Assert.assertTrue(NotebookPage.SuccessMessage().contains("Notebooks"));
    }


}
