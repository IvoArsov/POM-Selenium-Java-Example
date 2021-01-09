package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartConfirmationPopUp {
    WebDriver browser;
    WebDriverWait wait;

    public AddToCartConfirmationPopUp(WebDriver browserDriver){
        browser = browserDriver;

        // Wait for page load
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
    }

    public void confirmAddToCart(){
        WebElement confirmCheckoutBtn = browser.findElement(By.xpath("//a[@title='Proceed to checkout']"));
        confirmCheckoutBtn.click();
    }
}
