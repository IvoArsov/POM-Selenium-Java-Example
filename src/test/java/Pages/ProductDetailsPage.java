package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage {

    private By addToCartBtnLocator = By.xpath("//p[@id='add_to_cart']/button");

    public ProductDetailsPage(WebDriver browserDriver){
        super(browserDriver);

        // Wait for page load
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtnLocator));
    }

    public void addProductToCart(){
        WebElement addToCartBtn = browser.findElement(addToCartBtnLocator);
        addToCartBtn.click();
    }
}
