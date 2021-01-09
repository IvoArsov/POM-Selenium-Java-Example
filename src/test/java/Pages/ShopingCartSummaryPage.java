package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopingCartSummaryPage {
    WebDriver browser;
    WebDriverWait wait;

    public ShopingCartSummaryPage(WebDriver browserDriver){
        browser = browserDriver;

        // Wait for page load
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summary_products_quantity")));
    }

    public int getQuantityOfCheckoutProducts(){
        String productQuantityString = browser.findElement(By.id("summary_products_quantity")).getText();
        int spaceLocation = productQuantityString.indexOf(" ");
        int numProducts = Integer.parseInt(productQuantityString.substring(0, spaceLocation));
        return numProducts;
    }
}
