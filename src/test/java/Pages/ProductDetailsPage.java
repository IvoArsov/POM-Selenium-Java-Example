package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    WebDriver browser;
    WebDriverWait wait;

    public ProductDetailsPage(WebDriver browserDriver){
        browser = browserDriver;

        // Wait for page load
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='add_to_cart']/button")));
    }

    public void addProductToCart(){
        WebElement addToCartBtn = browser.findElement(By.xpath("//p[@id='add_to_cart']/button"));
        addToCartBtn.click();
    }
}
