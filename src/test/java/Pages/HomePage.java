package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    WebDriver browser;
    WebDriverWait wait;

    public HomePage(WebDriver browserDriver){
        browser = browserDriver;

        // Wait for page load
        WebDriverWait wait = new WebDriverWait(browser, 10);
    }

    public void navigateToLogIn(){
        WebElement logInLink = browser.findElement(By.cssSelector("a.login"));
        logInLink.click();
    }

    public List<WebElement> getProductNameLinks(){
        List<WebElement> productNamesList = browser.findElements(By.cssSelector("a.product-name"));
        return productNamesList;
    }
}
