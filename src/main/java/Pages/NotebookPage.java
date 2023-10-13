package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotebookPage {
    WebDriver driver;
    public NotebookPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By SuccessMessageAfterNavigateToNotebookPage=By.cssSelector("div[class=\"page-title\"] h1");
public String SuccessMessage()

{
    return driver.findElement(SuccessMessageAfterNavigateToNotebookPage).getText();
}




















































}
