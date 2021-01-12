package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    private By productNamesListLocator = By.cssSelector("a.product-name");
    private By contactUsLocator = By.cssSelector("#contact-link > a");

    public HomePage(WebDriver browserDriver){
        super(browserDriver);

        // Wait for page load
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsLocator));
    }


    public ProductDetailsPage selectProduct(int productIndex){
        List<WebElement> productNameLinks = getProductNameLinks();
        productNameLinks.get(productIndex).click();
        return new ProductDetailsPage(browser);
    }

    public ProductDetailsPage selectFirstProduct(){
        selectProduct(0);
        return new ProductDetailsPage(browser);
    }

    private List<WebElement> getProductNameLinks(){
        List<WebElement> productNamesList = browser.findElements(productNamesListLocator);
        return productNamesList;
    }
}
