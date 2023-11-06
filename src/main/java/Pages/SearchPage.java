package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private By SearchField = By.id("small-searchterms");
    private By SuggestProductAuto = By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/ul");

    public ProductDetailsPage setSearchField(String ProductName) throws InterruptedException {
        driver.findElement(SearchField).sendKeys(ProductName);
        List<WebElement> SuggestProduct = driver.findElements(SuggestProductAuto);

        SuggestProduct.get(0).click();
        return new ProductDetailsPage(driver);

    }


}
