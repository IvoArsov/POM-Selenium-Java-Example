package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    private By logInLinkLocator = By.cssSelector("a.login");
    private By productNamesListLocator = By.cssSelector("a.product-name");

    public HomePage(WebDriver browserDriver){
        super(browserDriver);

        // Wait for page load
        WebDriverWait wait = new WebDriverWait(browser, 10);
    }

    public LoginPage navigateToLoginPage(){
        WebElement logInLink = browser.findElement(logInLinkLocator);
        logInLink.click();
        return new LoginPage(browser);
    }

    public void selectProduct(int productIndex){
        List<WebElement> productNameLinks = getProductNameLinks();
        productNameLinks.get(productIndex).click();
    }

    public void selectFirstProduct(){
        selectProduct(0);
    }

    private List<WebElement> getProductNameLinks(){
        List<WebElement> productNamesList = browser.findElements(productNamesListLocator);
        return productNamesList;
    }
}
