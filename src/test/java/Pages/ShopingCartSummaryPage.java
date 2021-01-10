package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopingCartSummaryPage extends BasePage {

    private By productQuantityStringLocator = By.id("summary_products_quantity");

    public ShopingCartSummaryPage(WebDriver browserDriver){
        super(browserDriver);

        // Wait for page load
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityStringLocator));
    }

    public int getQuantityOfCheckoutProducts(){
        String productQuantityString = browser.findElement(productQuantityStringLocator).getText();
        int spaceLocation = productQuantityString.indexOf(" ");
        int numProducts = Integer.parseInt(productQuantityString.substring(0, spaceLocation));
        return numProducts;
    }
}
