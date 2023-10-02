package Hover;

import Pages.HomePage;
import Pages.NotebookPage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends TestBase {
    HomePage HomeObject;
    @Test
    public  void TC_HoverInteraction()
    {
        HomeObject=new HomePage(driver);
        NotebookPage NotebookPage=   HomeObject.Hoverhoverinteract();
        Assert.assertTrue(NotebookPage.SuccessMessage().contains("Notebooks"));
    }









































































}
