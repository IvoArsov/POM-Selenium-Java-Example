package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartConfirmationPopUp extends BasePage {

    private By confirmCheckoutBtnLocator = By.xpath("//a[@title='Proceed to checkout']");

    public AddToCartConfirmationPopUp(WebDriver browserDriver){
        super(browserDriver);

        // Wait for page load
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmCheckoutBtnLocator));
    }

    public ShopingCartSummaryPage proceedToCheckout(){
        WebElement confirmCheckoutBtn = browser.findElement(confirmCheckoutBtnLocator);
        confirmCheckoutBtn.click();
        return new ShopingCartSummaryPage(browser);
    }
}
