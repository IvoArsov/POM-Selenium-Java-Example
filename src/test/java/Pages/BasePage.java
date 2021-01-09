package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver browser;
    WebDriverWait wait;

    public BasePage(WebDriver browserDriver){
        browser = browserDriver;
        // Wait for page load
        WebDriverWait wait = new WebDriverWait(browser, 10);
    }
}
