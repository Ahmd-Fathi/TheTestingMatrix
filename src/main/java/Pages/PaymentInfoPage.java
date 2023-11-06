package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentInfoPage {
    WebDriver driver;

    public PaymentInfoPage(WebDriver driver) {
        this.driver = driver;
    }


    private By ContinuePaymentInfo = By.cssSelector("button[class=\"button-1 payment-info-next-step-button\"]");


    public confirmOrderPage clickContinuePaymentInfo() {
        driver.findElement(ContinuePaymentInfo).click();
        return new confirmOrderPage(driver);
    }


}
