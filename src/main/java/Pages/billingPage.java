package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class billingPage {
    WebDriver driver;

    public billingPage(WebDriver driver) {
        this.driver = driver;
    }

    //locator
    private By selectCountry = By.id("BillingNewAddress_CountryId");

    public void dropSelectCountry() {

        Select select = new Select(driver.findElement(selectCountry));
        select.selectByIndex(5);
    }
    //locator
    private By cityField = By.id("BillingNewAddress_City");

    public void setCityField(String city) {
        driver.findElement(cityField).sendKeys(city);
    }
    //locator
    private By addressField = By.id("BillingNewAddress_Address1");

    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
//locator

    private By zipCodeField = By.id("BillingNewAddress_ZipPostalCode");

    public void setZipCodeField(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    //locator
    private By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");

    public void setPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    //locator
    private By continueButton = By.cssSelector("button[onclick=\"Billing.save()\"]");

    //Method
    public shippingMethodPage clickcontinueButton() {
        driver.findElement(continueButton).click();
        return new shippingMethodPage(driver);
    }


}
