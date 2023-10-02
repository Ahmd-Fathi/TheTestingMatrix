package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class completecheckoutpage {
    WebDriver driver;
    public  completecheckoutpage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By successmessagecompletcheckoutpageloaded=By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");



public String getTxtsuccessmessagecompletcheckoutpageloaded()
{
   return driver.findElement(successmessagecompletcheckoutpageloaded).getText();
}






































































}
