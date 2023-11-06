package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentMethodPage {
    WebDriver driver;

    public PaymentMethodPage(WebDriver driver) {
        this.driver = driver;
    }


    private By ContinueOnPaymentMethod = By.cssSelector("button[class=\"button-1 payment-method-next-step-button\"]");


    public PaymentInfoPage clickContinueOnPaymentMethod() {
        driver.findElement(ContinueOnPaymentMethod).click();
        return new PaymentInfoPage(driver);
    }


}
