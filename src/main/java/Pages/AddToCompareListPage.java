package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCompareListPage {
    WebDriver driver;

    public AddToCompareListPage(WebDriver driver) {
        this.driver = driver;
    }
// locators
    private By CompareProductPageLoadSuccessMessage = By.cssSelector("div[class=\"page-title\"] h1");


    public String CompareProductPageLoadSuccessMessageDisplayed() {
        return driver.findElement(CompareProductPageLoadSuccessMessage).getText();
    }

    // locators
    private By AllTable = By.cssSelector("table[class=\"compare-products-table\"]");
    private By AllRows = By.tagName("tr");
    private By AllColumns = By.tagName("td");

    //Method
    public void InteractWithAllTable() {

        List<WebElement> allRows = driver.findElements(AllRows);
        int numberOfRows = allRows.size();
        System.out.println("Number of rows: " + numberOfRows);

        for (WebElement row : allRows) {
            System.out.println(row.getText() + "\t");
            List<WebElement> allColumns = row.findElements(AllColumns);
            for (WebElement colm : allColumns) {
                System.out.println(colm.getText() + "\t");
            }
        }


    }


}
