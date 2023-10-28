package download;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class downloadTest extends TestBase {

    @Test
    public  void download_Test() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");
        Thread.sleep(3000);

        driver.findElement(By.linkText("LambdaTest.txt")).click();
        Thread.sleep(3000);

    }







}
